package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.init.initializerStrategy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class H2DataInitStrategyDB implements DBInitializerStrategy {


    @Autowired
    private DataSource dataSource;

    @Override
    public void run() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            Resource resource = new ClassPathResource("h2-data.sql");
            ScriptUtils.executeSqlScript(conn, resource);
        }
    }
}
