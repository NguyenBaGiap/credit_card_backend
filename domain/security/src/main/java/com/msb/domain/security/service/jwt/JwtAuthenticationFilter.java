package com.msb.domain.security.service.jwt;

import com.msb.domain.customer.CustomerPersistencePort;
import com.msb.domain.security.models.customer.CustomerUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtTokenProvider jwtTokenProvider;
  final CustomerPersistencePort customerPersistencePort;

  public JwtAuthenticationFilter(
      JwtTokenProvider jwtTokenProvider, CustomerPersistencePort customerPersistencePort) {
    this.jwtTokenProvider = jwtTokenProvider;
    this.customerPersistencePort = customerPersistencePort;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String jwt = getJwtFromRequest(request);
      if (StringUtils.hasText(jwt) && jwtTokenProvider.validateCustomerToken(jwt)) {
        String mobileNumber = jwtTokenProvider.getMobileNumberFromToken(jwt);
        CustomerUserDetails details =
            customerPersistencePort
                .findByMobileNumber(mobileNumber)
                .map(CustomerUserDetails::new)
                .orElse(null);
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception exception) {
      logger.info("exception JWT check: {}", exception);
    }
    filterChain.doFilter(request, response);
  }

  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
