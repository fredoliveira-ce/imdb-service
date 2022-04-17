package nl.oliveira.user.dataprovider;

import nl.oliveira.user.usecase.User;

import java.util.Optional;

public interface UserDao {

  Optional<User> findUser(String username, Object credentials);

}
