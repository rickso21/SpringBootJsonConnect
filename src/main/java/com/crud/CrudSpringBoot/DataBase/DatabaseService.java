package com.crud.CrudSpringBoot.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DatabaseService {

    private final DatabaseConfig databaseConfig;
    @Autowired
    public DatabaseService(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }
    public void connectToDatabase() {
        try {
            String url = databaseConfig.getUrl();
            String username = databaseConfig.getUsername();
            String password = databaseConfig.getPassword();

            Connection connection = DriverManager.getConnection(url, username, password);
            // Ahora tienes una conexión a la base de datos PostgreSQL.
            // Puedes realizar operaciones JDBC aquí.
        } catch (SQLException e) {
            // Maneja cualquier excepción de SQL aquí.
            e.printStackTrace();
        }
    }
}
