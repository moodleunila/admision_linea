package mx.unila.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import mx.unila.edu.model.RelUsuarioRol;
import mx.unila.edu.model.TblUsuario;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private TblUsuarioRepository usuarioRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		TblUsuario user = usuarioRepository.findByUsername(auth.getName());

		if (user == null) {
			throw new BadCredentialsException("User not found");
		}

		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
			throw new BadCredentialsException("Wrong password");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		for (RelUsuarioRol role : user.getRelUsuarioRols()) {
			roles.add(new SimpleGrantedAuthority(role.getCatRol().getNombre()));
		}

		return new UsernamePasswordAuthenticationToken(user.getUsername(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}
