package com.gachashop.shop.ExceptionHandler.handler;

import com.gachashop.shop.ExceptionHandler.exception.ApiRequestException;
import com.gachashop.shop.ExceptionHandler.exception.DataBaseException;
import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.ExceptionHandler.exception.UniqueEntityException;
import com.gachashop.shop.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<ResponseDTO> handleApiRequestException(ApiRequestException e) {
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UniqueEntityException.class)
    public ResponseEntity<ResponseDTO> handleUniqueEntityException(UniqueEntityException e) {
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ResponseDTO> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ResponseDTO> handleDataBaseException(DataBaseException e) {
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    public ResponseDTO initExceptionResponse(RuntimeException e) {
        return new ResponseDTO(e);
    }
}
