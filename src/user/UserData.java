package user;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 22.12.12
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class UserData {
    String username;
    String email;
    int age;

    public void setUsername(String value) {
        username = value;
    }

    public void setEmail(String value) {
        email = value;
    }

    public void setAge(int value) {
        age = value;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
