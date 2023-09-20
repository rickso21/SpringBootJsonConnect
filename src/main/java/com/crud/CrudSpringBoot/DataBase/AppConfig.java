package com.crud.CrudSpringBoot.DataBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
@Configuration
public class AppConfig {

    @Bean
    public DatabaseConfig databaseConfig() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // File configFile = new File("C:/Users/eduardo.ruiz/Downloads/CronCargaDatos/src/main/resources/config/database-config.json"); // Asegúrate de que el archivo esté en la raíz del proyecto
        // File configFile = new File("./database-config.json"); // Asegúrate de que el archivo esté en la raíz del proyecto
        ClassPathResource resource = new ClassPathResource("./database-config.json");
        File configFile = resource.getFile();


        return objectMapper.readValue(configFile, DatabaseConfig.class);
    }

    @Bean
    public DataSource dataSource(DatabaseConfig databaseConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(databaseConfig.getUrl());
        dataSource.setUsername(databaseConfig.getUsername());
        dataSource.setPassword(databaseConfig.getPassword());

        return dataSource;
    }

}
