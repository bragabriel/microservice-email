package com.gabriel.emailmicroservice.infrastructure.persistence.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.gabriel.emailmicroservice.application.core.repositories")
public class MongoDBConfig {

    @Value("${DB_USER}")
    private String user;
    @Value("${DB_PASSWORD}")
    private String password;
    @Value("${DB_NAME}")
    private String database;

    @Bean
    public MongoDatabaseFactory mongoConfigure(){
        String connectionString = String.format("mongodb://%s:%s@127.0.0.1:27017/%s?authSource=admin",
                user, password, database);

        return new SimpleMongoClientDatabaseFactory(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoConfigure());
    }
}
