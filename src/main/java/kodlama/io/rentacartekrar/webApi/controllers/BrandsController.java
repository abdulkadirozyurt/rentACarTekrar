package kodlama.io.rentacartekrar.webApi.controllers;

import kodlama.io.rentacartekrar.business.abstracts.BrandService;
import kodlama.io.rentacartekrar.business.requests.CreateBrandRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacartekrar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();

    }
    @PostMapping ("/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@RequestBody @PathVariable int id){
        return this.brandService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
