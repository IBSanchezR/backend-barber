package backend.Mapper;

import backend.Dto.ClientDto;
import backend.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    IClientMapper INSTANCE = Mappers.getMapper(IClientMapper.class);

    ClientDto toDto(Client client); // Convertir de entidad a DTO
    Client toEntity(ClientDto clientDto); // Convertir de DTO a entidad
}