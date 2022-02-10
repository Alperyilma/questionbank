package mathbank.questionbank.business.abstracts;

import mathbank.questionbank.core.entities.User;

public interface UserService {

    User add(User user);
    void delete(User user);
    User findByEmail(String email);


}
