package kodlama.io.rentacartekrar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    private String name;
    private int brandId;                        // yeni oluşturulan model, hangi markaya ait?
}
