package com.shoppingcart.product.productservice.exception.advice;

import com.shoppingcart.product.productservice.exception.ProductServiceCustomException;
import com.shoppingcart.product.productservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseEntityExcheptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse>
    handleProductServiceException(ProductServiceCustomException exception){

        return new ResponseEntity<ErrorResponse>(
                        ErrorResponse.builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                .build()
                , HttpStatus.NOT_FOUND);

    }
}
