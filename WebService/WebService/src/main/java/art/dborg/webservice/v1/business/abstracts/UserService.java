package art.dborg.webservice.v1.business.abstracts;

import art.dborg.webservice.v1.entity.User;

public interface UserService {
    User save(User user);
    User update(User user);
    boolean delete(long id);
    User getUser(long id);
}
