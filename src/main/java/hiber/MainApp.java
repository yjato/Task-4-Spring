package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("Honda", 9);
      Car car2 = new Car("Mercedes", 63);
      Car car3 = new Car("BMW", 5);
      Car car4 = new Car("Toyota", 9);

      userService.add(new User("Daniil", "Vasyanin", "yjato@mail.ru",car1));
      userService.add(new User("Rustem", "Zinatulin", "gojodev@mail.ru",car2));
      userService.add(new User("Aleksandr", "Litvinov", "ali71996@mail.ru",car3));
      userService.add(new User("Konstantin", "Muravyov", "enderjer@mail.ru",car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
