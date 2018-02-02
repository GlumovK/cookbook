package ru.dartIt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.dartIt.model.User;
import ru.dartIt.to.UserTo;
import ru.dartIt.util.UserUtil;

import static java.util.Objects.requireNonNull;
public class AuthorizedUser {
    private static int id =1;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }



}
//public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
//    private static final long serialVersionUID = 1L;
//
//    private UserTo userTo;
//
//    public AuthorizedUser(User user) {
//        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
//        this.userTo = UserUtil.asTo(user);
//    }
//
//    public static AuthorizedUser safeGet() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null) {
//            return null;
//        }
//        Object principal = auth.getPrincipal();
//        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
//    }
//
//    public static AuthorizedUser get() {
//        AuthorizedUser user = safeGet();
//        requireNonNull(user, "No authorized user found");
//        return user;
//    }
//
//    public static int id() {
//        return get().userTo.getId();
//    }
//
//    public void update(UserTo newTo) {
//        userTo = newTo;
//    }
//
//    public UserTo getUserTo() {
//        return userTo;
//    }
//
//    @Override
//    public String toString() {
//        return userTo.toString();
//    }
//}