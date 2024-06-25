package marinalucentini.backend_w6_d2.entities;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Configuration
public class ConfBean {
    @Bean
    public Faker getFaker(){
        return new Faker(Locale.ITALY);
    }
}
