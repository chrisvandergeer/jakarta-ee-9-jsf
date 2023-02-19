package nl.cge.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Named(value = "user")
@RequestScoped
public class User {

    private String name;
    private String password;

    public void reset() {
        this.name = null;
        this.password = null;
    }
}