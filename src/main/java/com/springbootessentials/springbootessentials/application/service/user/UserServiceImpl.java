package com.springbootessentials.springbootessentials.application.service.user;

import com.springbootessentials.springbootessentials.application.ports.output.user.UserDao;
import com.springbootessentials.springbootessentials.application.service.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.domain.exception.UserExceptionsEnum;
import com.springbootessentials.springbootessentials.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserDetailsService {


    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userDao.findByUsername(username)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(UserExceptionsEnum.USER_NOT_FOUND));
    }


    public UserDetails createUser(User user) {
        return this.userDao.createUser(user);
    }


}
