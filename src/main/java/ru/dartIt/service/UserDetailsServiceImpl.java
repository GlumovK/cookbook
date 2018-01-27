package ru.dartIt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;
import ru.dartIt.model.User;
import ru.dartIt.repository.UserRepository;


import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email);


        GrantedAuthority auth = new GrantedAuthority() {
            private static final long serialVersionUID = 1L;

            public String getAuthority() {
                return "ROLE_USER";
            }
        };
        Set<GrantedAuthority> set = new HashSet<>();
        set.add(auth);

        UserDetails details =new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), set);
        return details;
    }
    }

