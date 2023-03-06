package kodlama.io.rentacartekrar.dataAccess.abstracts;

import kodlama.io.rentacartekrar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean existsByName(String name);
}
