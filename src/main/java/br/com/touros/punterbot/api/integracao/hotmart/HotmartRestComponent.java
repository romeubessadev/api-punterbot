package br.com.touros.punterbot.api.integracao.hotmart;

import br.com.touros.punterbot.api.core.configuracao.PunterbotApiConfiguracao;
import br.com.touros.punterbot.api.core.configuracao.HotmartConfiguracao;
import br.com.touros.punterbot.api.integracao.hotmart.exception.HotmartResponseException;
import br.com.touros.punterbot.api.integracao.hotmart.response.ErrorResponse;
import br.com.touros.punterbot.api.integracao.hotmart.response.TokeResponse;
import br.com.touros.punterbot.api.integracao.hotmart.response.UsuarioResponse;
import br.com.touros.punterbot.api.utils.Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class HotmartRestComponent {

    private final HotmartConfiguracao hotmartConfiguracao;

    private final WebClient webClientSeguranca;
    private final WebClient webClientApiHot;

    private final AtomicReference<String> token = new AtomicReference<>();

    public HotmartRestComponent(PunterbotApiConfiguracao punterbotApiConfiguracao) {
        this.hotmartConfiguracao = punterbotApiConfiguracao.getHotmart();

        this.webClientSeguranca = WebClient.builder()
                .filter(HotmartRestComponent.errorHandlingFilter())
                .baseUrl(HotmartConstants.URL_SECURITY)
                .defaultHeader(HotmartConstants.Header.AUTH, hotmartConfiguracao.getToken())
                .build();

        this.webClientApiHot = WebClient.create(HotmartConstants.URL_API_HOT);
    }

    public UsuarioResponse buscarUsuario(String code) {
        return null;
    }

    public TokeResponse buscarNovoToken() {
        TokeResponse tr = webClientSeguranca
                .post()
                .uri(uriBuilder -> Build(HotmartConstants.Uri.GET_TOKEN, uriBuilder))
                .retrieve()
                .bodyToFlux(TokeResponse.class)
                .doOnError(HotmartResponseException.class, e -> {
                })
                .blockFirst();

        if (!Utils.isNull(tr))
            this.token.set(tr.getAccessToken());

        return tr;
    }

    public URI Build(String uri, UriBuilder uriBuilder) {
        return uriBuilder
                .path(uri)
                .queryParam(HotmartConstants.Parameter.GRANT_TYPE, "client_credentials")
                .queryParam(HotmartConstants.Parameter.CLIENT_ID, hotmartConfiguracao.getId())
                .queryParam(HotmartConstants.Parameter.CLIENT_SECRET, hotmartConfiguracao.getSecret())
                .build();
    }

    public static ExchangeFilterFunction errorHandlingFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse != null) {
                if ((clientResponse.statusCode().is5xxServerError() || clientResponse.statusCode().is4xxClientError())) {
                    return clientResponse.bodyToMono(ErrorResponse.class).flatMap(errorBody -> Mono.error(new HotmartResponseException(errorBody, clientResponse.statusCode())));
                } else {
                    return Mono.just(clientResponse);
                }
            }
            return Mono.empty();
        });
    }
}
