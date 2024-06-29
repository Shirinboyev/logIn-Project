package uz.pdp.lesson.demo2.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public int age;
}
