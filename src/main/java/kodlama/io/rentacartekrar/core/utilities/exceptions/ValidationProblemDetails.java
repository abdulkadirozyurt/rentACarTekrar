package kodlama.io.rentacartekrar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
        // validation error aldık, marka isminin boyutunu size özelliğinden daha düşük verdik o yüzden "MethodArgumentNotValidException" aldık. bu yüzden böyle bir sınıf açtık,
        // Buradan RentACarTekrarApplication dosyamıza gidip bazı kodlar ekleyeceğiz.
        // hashmap kullanıcaz.    Map(hangi alanda, ne hatası var)
    private Map<String,String> validationErrors;
    private String name;


    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
