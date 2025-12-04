package tn.esprit.tp_foyer_ahmed_brahem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@SpringBootApplication
public class TpFoyerAhmedBrahemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpFoyerAhmedBrahemApplication.class, args);
    }

}
