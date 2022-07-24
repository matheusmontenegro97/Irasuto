package ifpe.br.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifpe.br.model.Artista;
import ifpe.br.repository.ArtistaRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	ArtistaRepository artistaRepository;

	public UserDetailsService(ArtistaRepository artistaRepository) {
		this.artistaRepository = artistaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Artista artista = artistaRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com o email:" + email));
		return new User(artista.getUsername(), artista.getPassword(), true, true, true,true, artista.getAuthorities());
	}
}
