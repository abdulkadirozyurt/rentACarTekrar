package kodlama.io.rentacartekrar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "models")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id")    // model tablomuza, brand_id alanını ekleyerek ilişkiyi kuracak.
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;      // aynı modelden bir sürü araba olabilir.

}
