package iceadobe.learning.spring.graphql.repository;

import iceadobe.learning.spring.graphql.model.User;
import lombok.NoArgsConstructor;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.addAll(Arrays.asList(
                new User(1, "John Doe 1", 12),
                new User(1, "John Doe 2", 12),
                new User(1, "John Doe 3", 12),
                new User(1, "John Doe 4", 12),
                new User(1, "John Doe 5", 12),
                new User(1, "John Doe 6", 12)
        ));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public List<User> getUserYoungerThan(int age) {
        return users.stream()
                .filter(user -> user.getAge() < age)
                .collect(Collectors.toList());
    }

    public User deleteUser(int id) throws HTTPException {
        Optional<User> user = this.getUserById(id);
        if (!user.isPresent())
            throw new HTTPException(403);
        users.remove(user.get());
        return user.get();
    }

}
