package fr.erickfranco.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.erickfranco.services.dto.DiplomaDto;
import fr.erickfranco.services.mapper.DiplomaMapper;
import fr.erickfranco.services.serviceinter.DiplomaInter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class DiplomaController {

	private final DiplomaInter diplomaInter;
	private final DiplomaMapper diplomaMapper;

	public DiplomaController(DiplomaInter diplomaInter, DiplomaMapper diplomaMapper) {
		this.diplomaInter = diplomaInter;
		this.diplomaMapper = diplomaMapper;
	}

	@GetMapping("all")
	public ResponseEntity<List<DiplomaDto>> getAll() {

		List<DiplomaDto> diplomaList = diplomaInter.findDiplomas();

		return ResponseEntity.ok().body(diplomaList);

	}

	@PostMapping("/diploma")
	public ResponseEntity<DiplomaDto> createDiplome(@Valid @RequestBody DiplomaDto diplomaDto) {
		DiplomaDto newDiplome = diplomaInter.createDiploma(diplomaDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(newDiplome);
	}

	@GetMapping(value = "/diploma/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<DiplomaDto>> getDiplomeById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(diplomaInter.findByDiplomaId(id));
	}

}
