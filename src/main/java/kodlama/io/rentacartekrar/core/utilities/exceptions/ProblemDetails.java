package kodlama.io.rentacartekrar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    String message;
}




// hata mesajlarının içeriğinin tamamını son kullanıcıya vermek istemiyoruz. Sadece mesaj kısmını vereceğiz.