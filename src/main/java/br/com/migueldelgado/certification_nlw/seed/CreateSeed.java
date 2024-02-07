package br.com.migueldelgado.certification_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {

    private final JdbcTemplate JdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.JdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);


    }

    public void run(String... args) {
        executeSqlFile("src/main/resources/create.sql");
    }

    public void executeSqlFile(String filePath) {
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));

            JdbcTemplate.execute(sqlScript);

            System.out.println("Seed realizado com sucesso");
        }
        catch(IOException e) {
            System.out.println("Erro ao executar arquivo: " + e.getMessage());
        }
    }
    
}
