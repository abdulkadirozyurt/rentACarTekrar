package kodlama.io.rentacartekrar.business.abstracts;

import kodlama.io.rentacartekrar.business.requests.CreateModelRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateModelRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
