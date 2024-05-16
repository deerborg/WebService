package art.dborg.webservice.v1.core.config.mail;

import art.dborg.webservice.v1.core.config.webService.WebServiceProperties;
import art.dborg.webservice.v1.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailSenderManager implements MailSenderService {

    private final SimpleMailMessage message;
    private final JavaMailSenderImpl mailSender;

    private final WebServiceProperties webServiceProperties;


    @Override
    public SimpleMailMessage sendActivationEmail(User user) {
        message.setFrom(webServiceProperties.getEmail().from());
        message.setTo(user.getEmail());
        message.setSubject("Activation Account");
        message.setText(webServiceProperties.getClient().host()+"/activation/" + user.getToken());
        getMailSender().send(message);
        return message;
    }

    @Override
    public JavaMailSender getMailSender() {
        mailSender.setHost(webServiceProperties.getEmail().host());
        mailSender.setPort(webServiceProperties.getEmail().port());
        mailSender.setUsername(webServiceProperties.getEmail().user());
        mailSender.setPassword(webServiceProperties.getEmail().password());
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", true);
        return mailSender;
    }
}
