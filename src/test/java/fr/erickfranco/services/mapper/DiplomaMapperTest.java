package fr.erickfranco.services.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


import fr.erickfranco.model.Diploma;
import fr.erickfranco.services.dto.DiplomaDto;

class DiplomaMapperTest {
	
	
	private DiplomaMapper mapper = Mappers.getMapper(DiplomaMapper.class);

	@Test
	void testDiplomaToDiplomaDto() {
		
		Diploma diplomaTest = new Diploma();

		diplomaTest.setId(1L);
		diplomaTest.setNameDiploma("Master 2 Sciences Politique");
		diplomaTest.setSchool("Université Lille 2");
		diplomaTest.setCity("Lille");
		diplomaTest.setDescription("Sint corrupti dolor ut earum cum sit ipsa molestias aliquam optio velit quidem optio similique");
		diplomaTest.setYear("24-11-2021");

		DiplomaDto diplomaDto = mapper.diplomaDtoToDiplome(diplomaTest);

		System.out.println(diplomaTest);
		System.out.println(diplomaDto);

		assertThat(diplomaDto.getIdDiploma()).isNotNull().isEqualTo(diplomaDto.getIdDiploma());

	}

}