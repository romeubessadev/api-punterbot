package br.com.touros.punterbot.api.core.security;

import br.com.touros.punterbot.api.core.security.authenticated.UsuarioAutenticado;
import br.com.touros.punterbot.api.core.security.authentication.LoginRequest;
import br.com.touros.punterbot.api.core.security.authentication.MongoAutenticacao;
import br.com.touros.punterbot.api.exceptions.UnauthorizedException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginAuthentication extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final long EXPIRATION_TIME = 172_800_000; // 2 dias

    private final Key signingKey;
    private final SignatureAlgorithm signatureAlgorithm;

    public LoginAuthentication(String url, AuthenticationManager authManager, String secret) {
        super(new AntPathRequestMatcher(url, "POST"));

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        signatureAlgorithm = SignatureAlgorithm.HS256;
        signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse rsp) throws AuthenticationException, IOException {
        LoginRequest autenticacaoRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
        Authentication authentication = new MongoAutenticacao(autenticacaoRequest.getEmail(), autenticacaoRequest.getSenha());

        getAuthenticationManager().authenticate(authentication);

        if (!authentication.isAuthenticated())
            throw new UnauthorizedException("Login Inválido", "Email ou senha incorretos");

        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse response, FilterChain chain, Authentication auth) {
        UsuarioAutenticado up = (UsuarioAutenticado) auth.getDetails();
        gerarResponse(response, up.getUsuarioLogado());
    }

    private void gerarResponse(HttpServletResponse response, Usuario usuario) {
        String jwt = gerarToken(usuario);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        loginResponse.setSolicitaSenha(usuario.getSolicitaNovaSenha());

        try {
            response.getWriter().print(OBJECT_MAPPER.writeValueAsString(loginResponse));
        } catch (IOException ignored) {
        }
        response.addHeader("Authorization", "Bearer" + " " + jwt);
    }

    private String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(String.valueOf(usuario.getStringId()))
                .setClaims(criarBodyDoToken(usuario))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

    private Map<String, Object> criarBodyDoToken(Usuario usuario) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("id", usuario.getStringId());
        body.put("nome", usuario.getNome());
        body.put("email", usuario.getEmail());
        body.put("bloqueado", usuario.getBloqueado());
        return body;
    }
}