package kodlama.io.rentacartekrar.webApi.controllers;

import kodlama.io.rentacartekrar.business.abstracts.ModelService;
import kodlama.io.rentacartekrar.business.requests.CreateModelRequest;
import kodlama.io.rentacartekrar.business.requests.UpdateModelRequest;
import kodlama.io.rentacartekrar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return this.modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }

}
