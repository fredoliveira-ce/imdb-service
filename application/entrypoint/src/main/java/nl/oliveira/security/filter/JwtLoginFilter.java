package nl.oliveira.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.oliveira.security.JwtUtils;
import nl.oliveira.user.usecase.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

  private User user;
  private final ObjectMapper mapper;

  public JwtLoginFilter(
    final String url,
    final AuthenticationManager authManager,
    final ObjectMapper mapper
  ) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authManager);
    this.mapper = mapper;
  }

  @Override
  public Authentication attemptAuthentication(
    final HttpServletRequest request,
    final HttpServletResponse response
  ) throws AuthenticationException, IOException {
    var userRequest = mapper.readValue(request.getInputStream(), User.class);

    final var authentication = getAuthenticationManager().authenticate(
      new UsernamePasswordAuthenticationToken(
        userRequest.getUsername(),
        userRequest.getPassword(),
        emptyList()
      )
    );

    this.user = (User) authentication.getPrincipal();
    return authentication;
  }

  @Override
  protected void successfulAuthentication(
    final HttpServletRequest request,
    final HttpServletResponse response,
    final FilterChain chain,
    final Authentication auth
  ) throws IOException {
    if (isNull(user)) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      response.getWriter().print(mapper.writeValueAsString(user));
      JwtUtils.addToken(response, auth.getName());
    }
  }

}
