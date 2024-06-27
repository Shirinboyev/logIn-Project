package uz.pdp.lesson.demo2;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public String signUp(String firstname, String lastname, String email, String password, int age) {
        List<User> users = userRepository.getAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return "Email already exists";
            }
        }

        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);

        userRepository.save(user);
        return "You are signed up";
    }

    public User logIn(String email, String password) {
        List<User> users = userRepository.getAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}