package kodlama.io.rentacartekrar.business.concretes;

import kodlama.io.rentacartekrar.business.abstracts.BrandService;
import kodlama.io.rentacartekrar.business.requests.CreateBrandRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacartekrar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentacartekrar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacartekrar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentacartekrar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

}
