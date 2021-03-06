package br.com.compasso.productms.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {
            body = Problem.builder()
                    .message(status.getReasonPhrase())
                    .status_code(status.value())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .message((String) body)
                    .status_code(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }


}
