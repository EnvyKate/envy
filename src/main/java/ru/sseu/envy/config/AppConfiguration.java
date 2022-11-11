package ru.sseu.envy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {



    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setName("database")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db.migration/V1.001__init.sql")
                .addScript("classpath:db.migration/V1.001__data.sql").build();
    }
}
