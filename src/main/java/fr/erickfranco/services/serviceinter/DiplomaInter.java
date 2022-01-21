package fr.erickfranco.services.serviceinter;

import java.util.List;
import java.util.Optional;

import fr.erickfranco.services.dto.DiplomaDto;

public interface DiplomaInter {

	public DiplomaDto createDiploma(DiplomaDto diplomaDto);

	public List<DiplomaDto> findDiplomas();

	public Optional<DiplomaDto> findByDiplomaId(Long id);

	public void deleteDiploma(Long id);

}