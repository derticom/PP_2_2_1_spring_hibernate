package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    @JoinColumn(name = "id")
    private int series;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
