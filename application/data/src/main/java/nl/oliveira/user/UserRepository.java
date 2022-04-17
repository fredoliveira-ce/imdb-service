package nl.oliveira.user;

import nl.oliveira.user.dataprovider.UserDao;
import nl.oliveira.user.usecase.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements UserDao {

  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "postgres";

  @Override
  public Optional<User> findUser(String username, Object credentials) {
    // TODO retrieve user from database.
    if(USERNAME.equals(username) && PASSWORD.equals(credentials)) {
      return Optional.of(User.builder().username(username).password(PASSWORD).build());
    }
    return Optional.empty();
  }
}
