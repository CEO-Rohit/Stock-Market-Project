package ai.ineuron.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ai.ineuron.exception.StockNotFoundException;

@RestControllerAdvice
public class StockNotFountExceptionHandler {

	@ExceptionHandler(value = StockNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFoundException(StockNotFoundException se) {
		return new ResponseEntity<String>(se.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
