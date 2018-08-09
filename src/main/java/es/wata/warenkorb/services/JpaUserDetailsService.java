package es.wata.warenkorb.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.wata.warenkorb.daos.KundeDAO;
import es.wata.warenkorb.entity.Kunde;
import es.wata.warenkorb.entity.Role;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private KundeDAO kundeDAO;

	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kunde kunde = kundeDAO.findByName(username);
		if (kunde == null) {
			logger.error("Error en el login, usuario " + username + " no existe em el sistema");
			throw new UsernameNotFoundException("Username " + username + " no existe en el sistema");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : kunde.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		if (authorities.isEmpty()) {
			logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
			throw new UsernameNotFoundException(
					"Error en el Login: usuario '" + username + "' no tiene roles asignados!");
		}
		return new User(kunde.getName(), kunde.getPassword(), kunde.getEnabled(), true, true, true, authorities);
	}

}
