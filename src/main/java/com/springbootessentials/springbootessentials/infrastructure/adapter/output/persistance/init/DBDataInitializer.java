package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.init;

import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.init.initializerStrategy.DBInitializerStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DBDataInitializer implements CommandLineRunner {


    private static final Logger log = LogManager.getLogger(DBDataInitializer.class);

    private List<DBInitializerStrategy> initializers;

    @Autowired
    public DBDataInitializer(List<DBInitializerStrategy> initializers) {
        this.initializers = initializers;
    }

    @Override
    public void run(String... args) throws Exception {
        for (DBInitializerStrategy initializer: initializers) {
            initializer.run();
        }
    }

}
