package nl.cge.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("userService")
@ApplicationScoped
public class UserService {

    private List<User> users;

    @PostConstruct
    void init() {
        users = new ArrayList<>();
        users.add(new User("Chris", "********"));
        users.add(new User("Duke", "J@v@"));
        users.add(new User("Teun", "V03d53l"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(new User(user.getName(), user.getPassword()));
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void changePassword(User user) {
        this.users.stream()
                .filter(u -> u.getName().equals(user.getName()))
                .findAny()
                .ifPresent(u -> u.setPassword(user.getPassword()));
    }

}
