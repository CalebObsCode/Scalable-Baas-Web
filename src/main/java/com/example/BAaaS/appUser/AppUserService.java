package com.example.BAaaS.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String NOT_FOUND_MSG = "User with given email %s not found";
    private final RespositoryUser respositoryUser;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return respositoryUser.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(NOT_FOUND_MSG)));
    }
}
