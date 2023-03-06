package kodlama.io.rentacartekrar.business.rules;

import kodlama.io.rentacartekrar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacartekrar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

        private BrandRepository brandRepository;

        public void checkIfBrandNameExists(String name){
            if (this.brandRepository.existsByName(name)){
                throw new BusinessException("Brand name already exists.");
                //throw new RuntimeException();     eğer runtime exception dersek, bizim bütün runtime hatalarımız business hatası olmadığı için onu ayrıca BusinessException ele almalıyız.
            }

        }
}


// bunu da enjekte ederek kullanacağızü bir yerde newlemeyeceğiz o yüzden @Service ile IoC ye yerleştiriyoruz.