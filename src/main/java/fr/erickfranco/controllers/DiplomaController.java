package fr.erickfranco.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

		List<DiplomaDto> diplomaList = diplomaInter.findAll();

		return ResponseEntity.ok().body(diplomaList);

	}

	@PostMapping("/diploma")
	public ResponseEntity<DiplomaDto> createDiplome(@Valid @RequestBody DiplomaDto diplomaDto) {
		DiplomaDto newDiplome = diplomaInter.save(diplomaDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(newDiplome);
	}

}
