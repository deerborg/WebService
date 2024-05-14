package art.dborg.webservice.v1.business.concretes;

import art.dborg.webservice.v1.business.abstracts.UserService;
import art.dborg.webservice.v1.core.config.modelMapper.ModelMapperService;
import art.dborg.webservice.v1.dao.UserRepository;
import art.dborg.webservice.v1.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
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
