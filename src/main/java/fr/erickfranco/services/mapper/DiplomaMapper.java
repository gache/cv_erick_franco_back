package fr.erickfranco.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.erickfranco.model.Diploma;
import fr.erickfranco.services.dto.DiplomaDto;

@Mapper(componentModel = "spring")
public interface DiplomaMapper {

	@Mapping(source = "id", target = "idDiploma")
	DiplomaDto diplomaDtoToDiplome(Diploma diploma);

	@Mapping(source = "idDiploma", target = "id")
	Diploma diplomaToDiplomaDto(DiplomaDto diplomaDto);

}