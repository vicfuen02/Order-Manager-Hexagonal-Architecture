package com.springbootessentials.springbootessentials.application.ports.output.user;

import com.springbootessentials.springbootessentials.domain.user.User;
import java.util.Optional;

public interface UserDao {


    Optional<User> findByUsername(String username);

    User createUser(User user);

}
