package art.dborg.webservice.v1.business.concretes;

import art.dborg.webservice.v1.business.abstracts.UserService;
import art.dborg.webservice.v1.core.config.PasswordEncoderConfig;
import art.dborg.webservice.v1.dao.UserRepository;
import art.dborg.webservice.v1.entity.User;
import art.dborg.webservice.v1.core.config.mail.MailSenderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderConfig encode;
    private final MailSenderManager manager;

    @Override
    public User save(User user) {
        user.setPassword(encode.getEncoder().encode(user.getPassword()));
        user.setToken(UUID.randomUUID().toString());
        manager.sendActivationEmail(user);
        return userRepository.save(user);
    }


    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(long id) {
        userRepository.delete(getUser(id));
        return true;
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
