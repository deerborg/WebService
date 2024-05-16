package art.dborg.webservice.v1.core.config;

import art.dborg.webservice.v1.core.exception.ForUpdateNotFoundIdException;
import art.dborg.webservice.v1.core.exception.NotFoundException;
import art.dborg.webservice.v1.core.exception.NotUniqueValues;
import art.dborg.webservice.v1.core.exception.SameValuesException;
import art.dborg.webservice.v1.core.result.Result;
import art.dborg.webservice.v1.core.result.ResultData;
import art.dborg.webservice.v1.core.utilites.Message;
import art.dborg.webservice.v1.core.utilites.ResultHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@ControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e) {
        List<String> errorList = e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(ResultHelper.ERROR(errorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MailException.class)
    public ResponseEntity<Result> handleMailExcepiton(){
        return new ResponseEntity<>(ResultHelper.MAIL_EXCEPTION(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Result> handleDataIntegrityViolationException() {
        return new ResponseEntity<>(ResultHelper.NOT_UNIQUE(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Result> handleNotReadableException() {
        return new ResponseEntity<>(ResultHelper.UNREADABLE(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException() {
        return new ResponseEntity<>(ResultHelper.NOT_FOUND_ID(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Result> handleNullPointerException() {
        return new ResponseEntity<>(ResultHelper.NULL_VALUES(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ForUpdateNotFoundIdException.class)
    public ResponseEntity<Result> handeUpdateNotFoundId() {
        return new ResponseEntity<>(ResultHelper.UPDATE_NOT_FOUND_ID(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotUniqueValues.class)
    public ResponseEntity<Result> handleNotUniqueValuesException() {
        return new ResponseEntity<>(ResultHelper.NOT_UNIQUE(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SameValuesException.class)
    public ResponseEntity<Result> handeSameValuesException() {
        return new ResponseEntity<>(ResultHelper.SAME_VALUES(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Result> resourceNotFoundException() {
        return new ResponseEntity<>(ResultHelper.RESOURCE_NOT_FOUND(), HttpStatus.BAD_GATEWAY);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Result> handleMissingServletRequestParameterException() {
        return new ResponseEntity<>(ResultHelper.MISSING_PARAMETER(), HttpStatus.BAD_REQUEST);
    }
}
