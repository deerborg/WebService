package art.dborg.webservice.v1.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MessageConfig {
    @Bean
    public SimpleMailMessage sendActivationEmail(){
        return new SimpleMailMessage();
    }

}
