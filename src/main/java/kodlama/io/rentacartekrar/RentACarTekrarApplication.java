package kodlama.io.rentacartekrar;

import kodlama.io.rentacartekrar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacartekrar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentacartekrar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
@SpringBootApplication
public class RentACarTekrarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarTekrarApplication.class, args);
    }


    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {
        //  yani business exception aldıysan o zaman çalış
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());                  // problemDetails'in mesajı, o an oluşan businessxception'ın mesajıdır dedik.

        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        //  yani MethodArgumentNotValidException aldıysan o zaman çalış dedik
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
        validationProblemDetails.setValidationErrors(new HashMap<String, String>());

        // swagger'da hatalar array olarak geldiği için dolaşmamız lazım.
        // hata bilgisi burada ---> (methodArgumentNotValidException)
        // ben bunu tek tek dolaşmam lazım

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());

        }


        return validationProblemDetails;


        // MethodArgumentNotValidException, içerisinde şunu bulunduruyor, hata mesajı+hangi field olduğunu. bunu da set etmeliyiz burada.

    }


    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}


//@RestControllerAdvice-> butun controller'lar bu exception handler'a tabidir.