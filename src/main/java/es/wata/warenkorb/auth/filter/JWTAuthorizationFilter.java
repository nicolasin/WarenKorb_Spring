package es.wata.warenkorb.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import es.wata.warenkorb.auth.service.JWTService;
import es.wata.warenkorb.auth.service.JWTServiceImplementation;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	
		private JWTService jwtService;
		
		public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
			super(authenticationManager);
			this.jwtService = jwtService;
		}
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			String header = request.getHeader(JWTServiceImplementation.HEADER_STING);
			if(!requiresAuthentication(header)) {
				chain.doFilter(request, response);
				return;
			}
			UsernamePasswordAuthenticationToken authentication = null;
			if(jwtService.validate(header)) {
				authentication = new UsernamePasswordAuthenticationToken(jwtService.getUsername(header), jwtService.getRoles(header));
			}
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		private boolean requiresAuthentication(String header) {
			if(header==null || !header.startsWith(JWTServiceImplementation.TOKEN_PREFIX)) {
				return false;
			}
			return true;
		}
}
