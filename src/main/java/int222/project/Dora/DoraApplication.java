package int222.project.Dora;

import int222.project.Dora.File.StorageProperties;
import int222.project.Dora.File.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class DoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoraApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {return (args) -> {};}
}
