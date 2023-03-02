package kodlama.io.rentacartekrar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "plate")
    private String plate;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "state")
    private int state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
