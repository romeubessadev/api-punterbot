package br.com.touros.punterbot.api.core.database;

import br.com.touros.punterbot.api.utils.Utils;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableConfigurationProperties(DatabaseMongoProperties.class)
public class DatabaseMongoConfiguration {

    private final DatabaseMongoProperties databaseMongoProperties;

    public DatabaseMongoConfiguration(DatabaseMongoProperties databaseMongoProperties) {
        this.databaseMongoProperties = databaseMongoProperties;
    }

    @Primary
    @Bean(name = "punterbotMongoTemplate")
    public MongoTemplate punterbotMongoTemplate() throws Exception {
        return new MongoTemplate(punterbotFactory(databaseMongoProperties.getPunterbot()));
    }

    @Bean
    @Primary
    public MongoDbFactory punterbotFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDbFactory(MongoClients.create(Url(mongo)), mongo.getDatabase());
    }

    private static String Url(MongoProperties mongo) {
        if (Utils.isNullOrEmpty(mongo.getUsername()))
            return "mongodb://" + mongo.getHost() + ":" + mongo.getPort();
        else {
            return "mongodb://" + mongo.getUsername() + ":" + Passsword(mongo) + "@" + mongo.getHost() + ":" + mongo.getPort();
        }
    }

    private static String Passsword(MongoProperties mongo) {
        return URLEncoder.encode(String.valueOf(mongo.getPassword()), StandardCharsets.UTF_8);
    }
}