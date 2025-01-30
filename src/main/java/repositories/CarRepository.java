package repositories;

import models.Car;
import repositories.base.CrudRepository;

public class CarRepository extends CrudRepository<Car, Long> {

    public CarRepository() {
        super(Car.class);
    }

}
