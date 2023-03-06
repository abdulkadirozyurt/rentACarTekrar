package kodlama.io.rentacartekrar.business.concretes;

import kodlama.io.rentacartekrar.business.abstracts.ModelService;
import kodlama.io.rentacartekrar.business.requests.CreateModelRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateModelRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacartekrar.business.responses.GetAllModelsResponse;
import kodlama.io.rentacartekrar.business.rules.ModelBusinessRules;
import kodlama.io.rentacartekrar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacartekrar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentacartekrar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    private ModelBusinessRules modelBusinessRules;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream().map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).toList();

        return modelsResponse;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
