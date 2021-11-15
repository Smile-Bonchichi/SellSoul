package kg.it_academy.sell_soul.util;

import kg.it_academy.sell_soul.exception.ApiErrorException;
import kg.it_academy.sell_soul.exception.ApiFailException;
import kg.it_academy.sell_soul.model.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiFailException.class)
    public ResponseEntity<ResponseMessage<String>> handleFailException(ApiFailException apiFailException) {
        ResponseMessage<String> failResponseMessage = new ResponseMessage<String>().prepareFailMessage(apiFailException.getMessage());
        String threwClassName = apiFailException.getStackTrace()[0].getClassName();
        log.warn(threwClassName + ":" + apiFailException.getMessage());
        return ResponseEntity.ok(failResponseMessage);
    }

    @ExceptionHandler(value = ApiErrorException.class)
    public ResponseEntity<ResponseMessage<String>> handleErrorException(ApiFailException apiFailException) {
        ResponseMessage<String> errorResponseMessage = new ResponseMessage<String>().prepareErrorMessage(apiFailException.getMessage());
        String threwClassName = apiFailException.getStackTrace()[0].getClassName();
        log.error(threwClassName + ":" + apiFailException.getMessage());
        return ResponseEntity.ok(errorResponseMessage);
    }
}