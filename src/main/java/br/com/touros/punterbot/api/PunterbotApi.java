package br.com.touros.punterbot.api;

import br.com.touros.punterbot.api.core.configuracao.PunterbotApiConfiguracao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

@EnableAsync
@EnableScheduling
@EnableConfigurationProperties({PunterbotApiConfiguracao.class})
@SpringBootApplication
public class PunterbotApi {
    public static void main(String[] args) {
        SpringApplication.run(PunterbotApi.class, args);
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }
}
