package mathbank.questionbank.business.abstracts;

import mathbank.questionbank.core.entities.User;

import java.util.List;

public interface UserService {

    User add(User user);
    void delete(User user);
    List<User> getAll();
    User findByEmail(String email);



}
