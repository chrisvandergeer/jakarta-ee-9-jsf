package nl.cge.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.*;
import java.util.stream.Stream;

@Named("userService")
@ApplicationScoped
public class UserService {

    private Map<String, User> users;

    @PostConstruct
    void init() {
        users = new LinkedHashMap<>();
        Stream.of(
                        new User("Chris", "********"),
                        new User("Duke", "J@v@"),
                        new User("Teun", "V03d53l"))
                .forEach(user -> users.put(user.getName(), user));
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public void addUser(User user) {
        if (!users.containsKey(user.getName())) {
            this.users.put(user.getName(), new User(user.getName(), user.getPassword()));
        }
    }

    public void deleteUser(User user) {
        this.users.remove(user.getName());
    }

    public void changePassword(User user) {
        Optional.ofNullable(users.get(user.getName())).ifPresent(u -> u.setPassword(user.getPassword()));
    }

}