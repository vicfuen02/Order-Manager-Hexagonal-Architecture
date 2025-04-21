package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.init.initializerStrategy;

import com.springbootessentials.springbootessentials.application.ports.output.user.UserDao;
import com.springbootessentials.springbootessentials.domain.user.User;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.init.DBDataInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserDBInitializerStrategy implements DBInitializerStrategy {

    private static final Logger log = LogManager.getLogger(DefaultUserDBInitializerStrategy.class);

    @Value("${spe.security.user.name:admin}")
    private String defaultAdminUsername;

    @Value("${spe.security.user.password:admin}")
    private String defaultAdminPassword;

    @Value("${spe.security.user.password:ADMIN}")
    private String defaultAdminRole;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run() throws Exception {
        log.info("ApplicationEvent default user creation.");
        if (userDao.findByUsername(defaultAdminUsername).isPresent()) {
            log.info("Default user already present in the DB");
            return;
        }

        log.info("Creating default user in the DB");

        User user = new User();
        user.setUsername(defaultAdminUsername);
        user.setPassword(this.passwordEncoder.encode(defaultAdminPassword));
        user.setRole(defaultAdminRole.toUpperCase());

        userDao.createUser(user);
        log.info("Created default user in the DB");
    }
}
