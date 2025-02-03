import models.Car;
import models.User;
import repositories.BookRepository;
import repositories.CarRepository;
import repositories.EditorRepository;
import repositories.UserRepository;

public class Main {

    public static void main(String[] args) {

        var userRepo = new UserRepository();
        var carRepo = new CarRepository();
        var bookRepo = new BookRepository();
        var editorRepo = new EditorRepository();


        User user = new User("Michel");
        user = userRepo.insert(user);
        System.out.println("Utilisateur ajouté : " + user.getName() );
        Car car = new Car("red",user);
        car = carRepo.insert(car);
        System.out.println(car.getColor());
        System.out.println("CAR BY USER");
        userRepo.findCarsByUserId(user.getId()).forEach(System.out::println);
        System.out.println("Hello");

    }
}
