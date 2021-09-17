package com.github.matheusmv.hroauth.services;

import com.github.matheusmv.hroauth.entities.User;
import com.github.matheusmv.hroauth.feignclients.UserFeignClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public Optional<User> findByEmail(String email) {
        try {
            var user = userFeignClient.getByEmail(email).getBody();

            logger.error("Email found: " + email);

            return Optional.ofNullable(user);
        } catch (FeignException exception) {
            logger.error("Email not found: " + email);

            return Optional.empty();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var user = userFeignClient.getByEmail(username).getBody();

            logger.error("Email found: " + username);

            return user;
        } catch (FeignException exception) {
            logger.error("Email not found: " + username);

            throw new UsernameNotFoundException("Email found: " + username);
        }
    }
}
