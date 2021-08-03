package nl.lunatech.user;

import nl.lunatech.user.dataprovider.UserDao;
import nl.lunatech.user.usecase.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class UserMockRepository implements UserDao {

  public static final String USERNAME = "test";

  @Override
  public Optional<User> findUser(String username, Object credentials) {
    if (!USERNAME.equals(username)) {
      throw new UserUnauthorizedException(username);
    }

    return Optional.of(
      User.builder()
        .username(username)
        .build());
  }
}
