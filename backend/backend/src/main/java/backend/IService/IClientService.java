package backend.IService;

import backend.Dto.ClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> findAll();
    ClientDto findById(Long id);
    ClientDto save(ClientDto clientDto);
    ClientDto update(Long id, ClientDto clientDto);
    void deleteById(Long id);
}