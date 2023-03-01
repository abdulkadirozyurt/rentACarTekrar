package kodlama.io.rentacartekrar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarTekrarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarTekrarApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
