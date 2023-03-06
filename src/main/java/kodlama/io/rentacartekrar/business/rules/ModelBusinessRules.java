package kodlama.io.rentacartekrar.business.rules;

import kodlama.io.rentacartekrar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacartekrar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;
    public void checkIfModelNameExists(String name){
        if (this.modelRepository.existsByName(name)){
            throw new BusinessException("Model name already exists.");
        }
    }
}
