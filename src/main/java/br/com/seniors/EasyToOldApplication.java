package br.com.seniors;

import br.com.seniors.model.ServiceTarget;
import br.com.seniors.repository.ServiceTargetRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EasyToOldApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyToOldApplication.class, args);
    }

    @Autowired
    private ServiceTargetRepository serviceTargetRepository;

//    @Bean
//    public CommandLineRunner init() {
//        return (args) -> {
//            serviceTargetRepository.save(Arrays.asList(
////                    new ServiceTarget("MODA E BELEZA"),
////                    new ServiceTarget("SAÚDE"),
////                    new ServiceTarget("CASA E APARTAMENTO"),
////                    new ServiceTarget("EMPRESA")
//            ));
//        };
//    }
    
}
