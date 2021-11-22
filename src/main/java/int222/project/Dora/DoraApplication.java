package int222.project.Dora;

import int222.project.Dora.File.StorageProperties;
import int222.project.Dora.File.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class DoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoraApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {return (args) -> {};}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("PUT", "DELETE",
						"GET", "POST","OPTIONS").allowedHeaders("Authorization").exposedHeaders("Authorization");
			}
		};
	}
}
