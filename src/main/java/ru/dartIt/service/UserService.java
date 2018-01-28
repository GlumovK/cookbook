package ru.dartIt.service;

import ru.dartIt.model.User;
import ru.dartIt.to.UserTo;
import ru.dartIt.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

  //  void update(User user);

    List<User> getAll();

    void enable(int id, boolean enable);

    void update(UserTo user);
}
