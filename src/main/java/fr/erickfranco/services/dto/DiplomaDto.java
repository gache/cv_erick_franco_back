package fr.erickfranco.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomaDto {

	private Long idDiploma;

	private String nameDiploma;

	private String school;

	private String city;

	private String description;

	private String year;

}