package in.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(value = EmpAlreadyExistException.class)
	    @ResponseStatus(HttpStatus.CONFLICT)
	    @ResponseBody
	    public ErrorResponse handleEmpAlreadyExistException(EmpAlreadyExistException ex) {
			ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	    	return error;
	    }
	    // We can also use ResponseEntity class 
	    @ExceptionHandler(value = NoSuchEmpExistException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ResponseBody
	    public ResponseEntity<ErrorResponse> handleNoSuchEmpExistException(NoSuchEmpExistException ex) {
			ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	    	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	    	
	    }
	    @ExceptionHandler(value = NullPointerException.class)
	    @ResponseStatus(HttpStatus.CONFLICT)
	    @ResponseBody
	    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
			ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	    	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	    	
	    }
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>>handleValidationError(MethodArgumentNotValidException ex){
			Map<String,String>errorsMap = new HashMap<>();
			ex.getBindingResult().getFieldErrors().forEach(error->{
				errorsMap.put(error.getField(),error.getDefaultMessage());});
           return  new ResponseEntity<>(errorsMap,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(Exception.class)
			public ResponseEntity<ErrorResponse>handleGenericException(Exception ex){
				ErrorResponse errorResponse= new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage() );
				return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
}
