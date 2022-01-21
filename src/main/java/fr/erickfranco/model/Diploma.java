package fr.erickfranco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diploma")
public class Diploma {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(length = 80)
	private String nameDiploma;

	@Column(length = 40)
	private String school;

	@Column(length = 30)
	private String city;

	@Column(columnDefinition = "text")
	private String description;

	private String year;

}
