package br.com.touros.punterbot.api.core.security.filter;

import br.com.touros.punterbot.api.core.permission.PermissaoAutenticacao;
import br.com.touros.punterbot.api.exceptions.UnauthorizedException;
import br.com.touros.punterbot.api.model.cadastro.Usuario;
import br.com.touros.punterbot.api.service.interfaces.IUsuarioService;
import br.com.touros.punterbot.api.utils.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;


public class ReadTokenFilter extends OncePerRequestFilter {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReadTokenFilter.class);

    private final Key signingKey;
    private final IUsuarioService usuarioService;

    public ReadTokenFilter(String secret, IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = autenticarRequest(request);

        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }

    private Authentication autenticarRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty())
            return null;

        token = token.replace("Bearer", "");

        Claims body = null;

        try {
            body = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception exJwt) {
            UnauthorizedException.Throw("Token Inválido", exJwt.getMessage());
        }

        String email = body.get("email", String.class);
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (Utils.isNull(usuario))
            throw new UnauthorizedException("Não Autorizado", "Usuário Não Encontrado");

        UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(usuario, usuario.getEmail(), PermissaoAutenticacao.Roles(usuario));

        // Seta o usuario id no detalhe
        usernamePassAuthToken.setDetails(usuario.getStringId());

        return usernamePassAuthToken;
    }

}
