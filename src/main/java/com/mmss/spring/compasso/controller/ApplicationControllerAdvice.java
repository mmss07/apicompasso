package com.mmss.spring.compasso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mmss.spring.compasso.ApiErrors;
import com.mmss.spring.compasso.exception.RegraNegocioException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	 @ExceptionHandler(RegraNegocioException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ApiErrors handleRegraNegocioException(RegraNegocioException ex){
	        String mensagemErro = ex.getMessage();
	        return new ApiErrors(mensagemErro);
	    }

}
