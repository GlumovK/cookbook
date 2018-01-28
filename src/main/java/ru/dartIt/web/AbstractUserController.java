package ru.dartIt.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dartIt.model.User;
import ru.dartIt.service.UserService;
import ru.dartIt.to.UserTo;

import java.util.List;

import static ru.dartIt.util.ValidationUtil.assureIdConsistent;
import static ru.dartIt.util.ValidationUtil.checkNew;


public abstract class AbstractUserController {


    @Autowired
    private UserService service;

    public List<User> getAll() {

        return service.getAll();
    }

    public User get(int id) {

        return service.get(id);
    }

    public User create(User user) {

        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {

        service.delete(id);
    }



    public void update(UserTo userTo, int id) {

       // assureIdConsistent(userTo, id);
        service.update(userTo);
    }

    public User getByMail(String email) {

        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {

        service.enable(id, enabled);
    }
}