package kodlama.io.rentacartekrar.business.abstracts;

import kodlama.io.rentacartekrar.business.requests.CreateBrandRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacartekrar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete (int id);

}
