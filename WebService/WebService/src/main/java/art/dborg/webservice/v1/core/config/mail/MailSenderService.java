package art.dborg.webservice.v1.core.config.mail;

import art.dborg.webservice.v1.entity.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public interface MailSenderService {
    SimpleMailMessage sendActivationEmail(User user);
    JavaMailSender getMailSender();
}
