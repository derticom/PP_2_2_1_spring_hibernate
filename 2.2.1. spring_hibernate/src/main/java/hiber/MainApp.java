package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Ivan", "Frolov", "ivan@mail.ru", new Car("VAZ", 2110)));

        userService.add(new User("Petr", "Efimov", "petr@bk.ru", new Car("UAZ", 469)));

        userService.add(new User("John", "Parker", "john@gmail.com", new Car("Moskvich", 412)));

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());

            System.out.println();
        }

        System.out.println("User with required car: " + userService.getUserByCar("Moskvich", 412));

        context.close();
    }
}
