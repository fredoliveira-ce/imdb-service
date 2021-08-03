package nl.lunatech.user.dataprovider;

import nl.lunatech.user.usecase.User;

import java.util.Optional;

public interface UserDao {

  Optional<User> findUser(String username, Object credentials);

}
