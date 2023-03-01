package kodlama.io.rentacartekrar.dataAccess.abstracts;

import kodlama.io.rentacartekrar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {

}