
package br.com.touros.punterbot.api.controller;

import br.com.touros.punterbot.api.controller.response.BaseResponse;
import br.com.touros.punterbot.api.exceptions.BaseException;
import br.com.touros.punterbot.api.exceptions.UnauthorizedException;
import br.com.touros.punterbot.api.exceptions.ValidException;
import br.com.touros.punterbot.api.utils.Utils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Controller
public class CustomErrorController implements ErrorController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> UnauthorizedException(BaseException baseException) {
        return new ResponseEntity<>(new BaseResponse(baseException.getMensagem()), baseException.getHttpStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> Exception(AccessDeniedException ex) {
        BaseResponse error = new BaseResponse("Recurso não permitido");
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> Exception(Exception ex) {
        ex.printStackTrace();
        String mensagem = Utils.isNullOrEmpty(ex.getMessage()) ? ex.toString() : ex.getMessage();
        BaseResponse error = new BaseResponse("Erro interno:" + mensagem);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/error")
    public ResponseEntity<BaseResponse> error(HttpServletRequest request) {
        return getError(request);
    }

    private ResponseEntity<BaseResponse> getError(HttpServletRequest request) {
        Object objectException = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMensagem("Erro Interno");
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (!Utils.isNull(objectException)) {

            if (objectException instanceof BaseException) {
                return UnauthorizedException((BaseException) objectException);
            } else if (objectException instanceof Exception) {
                return Exception((Exception) objectException);
            }
        }

        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    private HttpStatus status(Throwable throwable) {
        if (Utils.isNull(throwable))
            return HttpStatus.INTERNAL_SERVER_ERROR;

        if (throwable instanceof ValidException)
            return HttpStatus.PRECONDITION_FAILED;

        if (throwable instanceof UnauthorizedException)
            return HttpStatus.UNAUTHORIZED;

        return HttpStatus.INTERNAL_SERVER_ERROR;

    }

    private String titulo(Throwable throwable) {
        if (Utils.isNull(throwable))
            return "Erro Interno";

        if (throwable instanceof UnauthorizedException)
            return "Não Autorizado";

        return "Erro Interno";
    }

    private Throwable getExceptionFromRequest(HttpServletRequest request) {
        return (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
