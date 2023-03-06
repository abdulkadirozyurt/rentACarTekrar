package kodlama.io.rentacartekrar.dataAccess.abstracts;

import kodlama.io.rentacartekrar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
        // marka adını kontrol etmek için oluşturduğumuz business rules kısmındaki metotta find by name gibi bir şey olmadığı için kendi metodumuzu yazıyoruz.
        boolean existsByName(String name);

}
