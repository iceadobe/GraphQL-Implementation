package iceadobe.learning.spring.graphql.graphql;

import graphql.schema.DataFetcher;
import iceadobe.learning.spring.graphql.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserFetcher {
    UserRepository userRepo = new UserRepository();

    public DataFetcher getAllUsers(){
        return dataFetchingEnvironment -> userRepo.getAllUsers();
    }

    public DataFetcher getUserById() {
        return dataFetchingEnvironment -> userRepo.getUserById(Integer.parseInt(dataFetchingEnvironment.getArgument("id")));
    }

    public DataFetcher getUserYoungerThan() {
        return dataFetchingEnvironment -> userRepo.getUserYoungerThan(Integer.parseInt(dataFetchingEnvironment.getArgument("age")));
    }

    public DataFetcher deleteUser() {
        return dataFetchingEnvironment -> userRepo.deleteUser(Integer.parseInt(dataFetchingEnvironment.getArgument("id")));
    }
}

