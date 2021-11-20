package kg.it_academy.sell_soul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SellSoulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellSoulApplication.class, args);
    }

}
