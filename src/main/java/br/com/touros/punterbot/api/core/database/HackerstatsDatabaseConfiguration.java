package br.com.touros.punterbot.api.core.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.touros.punterbot.api.repository",
        mongoTemplateRef = "punterbotMongoTemplate")
public class HackerstatsDatabaseConfiguration {
}
