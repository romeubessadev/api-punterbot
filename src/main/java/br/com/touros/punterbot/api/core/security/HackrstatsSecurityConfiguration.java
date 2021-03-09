package br.com.touros.punterbot.api.core.security;

import br.com.touros.punterbot.api.controller.response.BaseResponse;
import br.com.touros.punterbot.api.core.configuracao.PunterbotApiConfiguracao;
import br.com.touros.punterbot.api.core.security.filter.ReadTokenFilter;
import br.com.touros.punterbot.api.core.security.providers.MongoAuthenticationProvider;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.OutputStream;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true, proxyTargetClass = true)
public class HackrstatsSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String token;
    private final MongoAuthenticationProvider mongoAuthenticationProvider;
    private final IUsuarioService usuarioService;

    public HackrstatsSecurityConfiguration(MongoAuthenticationProvider mongoAuthenticationProvider, PunterbotApiConfiguracao punterbotApiConfiguracao, IUsuarioService usuarioService) {
        this.mongoAuthenticationProvider = mongoAuthenticationProvider;
        this.token = punterbotApiConfiguracao.getSeguranca().getToken();
        this.usuarioService = usuarioService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(mongoAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .csrf()
                .disable()
                .addFilter(corsFilter())
                .authorizeRequests()
                .antMatchers(
                        "/webjars/**", "swagger-resources", "/swagger-resource/**", "/swagger-resources/**", "/v2/api-docs", "/swagger-ui**", "/favicon.ico",
                        "/autenticacao/login", "/error")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                    BaseResponse response = new BaseResponse("Acesso Não Autorizado");
                    httpServletResponse.setStatus(401);
                    OutputStream out = httpServletResponse.getOutputStream();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(out, response);
                    out.flush();
                })
                .and()
                .addFilterBefore(new ReadTokenFilter(token, usuarioService), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new LoginAuthentication("/autenticacao/login", authenticationManager(), token), UsernamePasswordAuthenticationFilter.class);
    }

    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addExposedHeader("Authorization");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



}
