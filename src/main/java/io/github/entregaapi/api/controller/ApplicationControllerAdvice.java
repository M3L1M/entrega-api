package io.github.entregaapi.api.controller;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.entregaapi.api.ApiErrors;
import io.github.entregaapi.exception.RegraNegocioException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(BAD_REQUEST)
	public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
		String mensagem=ex.getMessage();
		return new ApiErrors(mensagem);
	}
	
}
