import models.Car;
import models.User;
import repositories.CarRepository;
import repositories.UserRepository;

public class Main {

    public static void main(String[] args) {

        var userRepo = new UserRepository();
        var carRepo = new CarRepository();

        User user = new User(null, "Michel");
        user = userRepo.insert(user);
        System.out.println("Utilisateur ajouté : " + user.getName() );

        Car car = new Car(null, "red");
        car = carRepo.insert(car);

    }
}
