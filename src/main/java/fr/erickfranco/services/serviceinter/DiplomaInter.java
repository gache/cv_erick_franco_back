package fr.erickfranco.services.serviceinter;

import java.util.List;
import java.util.Optional;

import fr.erickfranco.services.dto.DiplomaDto;

public interface DiplomaInter {

	DiplomaDto save(DiplomaDto diplomaDto);

	List<DiplomaDto> findAll();

	Optional<DiplomaDto> findOne(Long id);

	void delete(Long id);

}