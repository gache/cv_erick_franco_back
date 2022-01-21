package fr.erickfranco.services.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.erickfranco.configuration.exception.BadRequestExcepton;
import fr.erickfranco.model.Diploma;
import fr.erickfranco.repositories.DiplomaRepository;
import fr.erickfranco.services.dto.DiplomaDto;
import fr.erickfranco.services.mapper.DiplomaMapper;
import fr.erickfranco.services.serviceinter.DiplomaInter;

@Service
public class DiplomeServiceImpl implements DiplomaInter {

	private final DiplomaRepository diplomaRepository;
	private final DiplomaMapper diplomaMapper;

	public DiplomeServiceImpl(DiplomaRepository diplomaRepository, DiplomaMapper diplomaMapper) {
		super();
		this.diplomaMapper = diplomaMapper;
		this.diplomaRepository = diplomaRepository;
	}

	@Override
	public DiplomaDto createDiploma(DiplomaDto diplomaDto) {
		Diploma diploma = diplomaMapper.diplomaToDiplomaDto(diplomaDto);

		/*
		 * if (diplomaRepository.findById(diplomaDto.getIdDiploma()).isPresent()) {
		 * throw new DiplomaAlreadyExistException("Resource already exists"); }
		 */
		diploma = diplomaRepository.save(diploma);

		return diplomaMapper.diplomaDtoToDiplome(diploma);
	}

	@Override
	public List<DiplomaDto> findDiplomas() {
		return diplomaRepository.findAll().stream().map(diplomaMapper::diplomaDtoToDiplome)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<DiplomaDto> findByDiplomaId(Long id) {

		if (!diplomaRepository.existsById(id)) {
			throw new BadRequestExcepton("Le Diplôme avec l'id " + id + " n'existe pas ");
		}
		return diplomaRepository.findById(id).map(diplomaMapper::diplomaDtoToDiplome);
	}

	@Override
	public void deleteDiploma(Long id) {
		diplomaRepository.deleteById(id);
	}

}