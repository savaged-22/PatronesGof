package co.patronesgof.fis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import co.patronesgof.fis.repositories.BusRepository;
import co.patronesgof.fis.repositories.UsuarioRepository;
import co.patronesgof.fis.services.BusFactoryService;
import co.patronesgof.fis.services.RutaFactoryService;

@SpringBootApplication
public class PatronesGofApplication {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatronesGofApplication.class, args);

        // Repositorios
        BusRepository busRepo = new BusRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        // Fábricas
        BusFactoryService busFactory = new BusFactoryService();
        RutaFactoryService rutaFactory = new RutaFactoryService();
    }
}
