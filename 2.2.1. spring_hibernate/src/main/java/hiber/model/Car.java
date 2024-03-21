package hiber.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    private User user;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;



    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.setCar(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", user=" + user +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(id, car.id) && Objects.equals(user, car.user) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, series, model);
    }
}
