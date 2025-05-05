package backend.Service;

import backend.IService.IClientService;
import backend.Mapper.IClientMapper;
import backend.Dto.ClientDto;
import backend.Entity.Client;
import backend.Repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;

    @Autowired
    private IClientMapper clientMapper; // Se cambió el nombre a minúsculas

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = iClientRepository.findByEstadoTrue();
        return clients.stream().map(clientMapper::toDto).toList();
    }

    @Override
    public ClientDto findById(Long id) {
        return iClientRepository.findByIdAndEstadoTrue(id)
                .map(clientMapper::toDto)
                .orElse(null);
    }

    @Transactional
    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        client.setFechaCreacion(LocalDate.now());
        client.setEstado(true);
        client.setMembershipLevel("BASIC");
        client.setPoints(0);
        client = iClientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Transactional
    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        return iClientRepository.findByIdAndEstadoTrue(id)
                .map(client -> {
                   client.setName(clientDto.name());
                   client.setLastName(clientDto.lastName());
                   client.setCellPhone(clientDto.cellPhone());
                   client.setNotes(clientDto.notes());
                   Client updateClient = iClientRepository.save(client);
                   return clientMapper.toDto(updateClient);
                })
                .orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Optional<Client> client = iClientRepository.findByIdAndEstadoTrue(id);
        client.ifPresent(c -> {
            c.setEstado(false);
            c.setPoints(0);
            c.setFechaEliminacion(LocalDate.now());
            iClientRepository.save(c);
        });
    }
}