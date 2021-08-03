package nl.lunatech.user.usecase;

import lombok.RequiredArgsConstructor;
import nl.lunatech.user.UserUnauthorizedException;
import nl.lunatech.user.dataprovider.UserDao;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends AbstractUserDetailsAuthenticationProvider {

  private final UserDao dao;

  @Override
  protected void additionalAuthenticationChecks(
    final UserDetails userDetails,
    final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
  ) throws AuthenticationException { }

  @Override
  protected UserDetails retrieveUser(
    final String username,
    final UsernamePasswordAuthenticationToken authentication
  ) throws AuthenticationException {
    return dao.findUser(username, authentication.getCredentials())
      .orElseThrow(() -> new UserUnauthorizedException(username));

  }

}
