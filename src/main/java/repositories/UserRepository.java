package repositories;

import models.User;
import repositories.base.CrudRepository;

public class UserRepository extends CrudRepository<User, Long> {

    public UserRepository() {
        super(User.class);
    }

}
