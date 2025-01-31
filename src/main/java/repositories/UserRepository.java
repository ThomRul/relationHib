package repositories;

import models.Car;
import models.User;
import repositories.base.CrudRepository;

import java.util.List;

public class UserRepository extends CrudRepository<User, Long> {

    public UserRepository() {
        super(User.class);
    }
    public List<Car> findCarsByUserId(Long userId) {
        User user = getOne(userId);
        return user.getCars();
    }
}
