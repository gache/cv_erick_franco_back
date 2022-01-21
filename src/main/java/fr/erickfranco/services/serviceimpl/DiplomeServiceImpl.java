package fr.erickfranco.services.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
	public DiplomaDto save(DiplomaDto diplomaDto) {
		Diploma diploma = diplomaMapper.diplomaToDiplomaDto(diplomaDto);
		diploma = diplomaRepository.save(diploma);
		return diplomaMapper.diplomaDtoToDiplome(diploma);
	}

	@Override
	public List<DiplomaDto> findAll() {
		return diplomaRepository.findAll().stream().map(diplomaMapper::diplomaDtoToDiplome)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<DiplomaDto> findOne(Long id) {
		return diplomaRepository.findById(id).map(diplomaMapper::diplomaDtoToDiplome);
	}

	@Override
	public void delete(Long id) {
		diplomaRepository.deleteById(id);
	}

}