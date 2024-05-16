package art.dborg.webservice.v1.core.config.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailSenderConfig {
    @Bean
    public JavaMailSenderImpl getMailSender(){
        return new JavaMailSenderImpl();
    }
}
