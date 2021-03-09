package br.com.touros.punterbot.api.core.database;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
public class DatabaseMongoProperties {

    private MongoProperties punterbot = new MongoProperties();

    public void setPunterbot(MongoProperties punterbot) {
        this.punterbot = punterbot;
    }

    public MongoProperties getPunterbot() {
        return punterbot;
    }
}