package fr.erickfranco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ @PropertySource(value = "classpath:application.properties"),
		@PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true) })
public class CvErickFrancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvErickFrancoApplication.class, args);
	}

}
