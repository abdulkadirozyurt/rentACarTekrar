package kodlama.io.rentacartekrar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
    private int id;
    private String name;
    private String brandName;       // modelMapper bunu, join atarak bizim için getirecek----> Model'in Brand'inin Name'i şeklinde mapleyip join atar.
}
