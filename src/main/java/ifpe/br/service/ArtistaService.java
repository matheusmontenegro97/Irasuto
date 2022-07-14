package ifpe.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.Artista;
import ifpe.br.model.RequestLogin;
import ifpe.br.model.Usuario;
import ifpe.br.repository.ArtistaRepository;
import ifpe.br.repository.UsuarioRepository;

@Service
public class ArtistaService {
	
	@Autowired
	ArtistaRepository artistaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Artista createArtista(Artista artista) {
		Artista artistaSaved = artistaRepository.save(artista);
		
		Usuario usuario = new Usuario();
		usuario.setEmail(artista.getEmail());
		usuario.setSenha(artista.getSenha());
		usuario.setArtista(artistaSaved);
		
		usuarioRepository.save(usuario);
		
		return artistaSaved;
	}
	
	public Usuario retornaUsuarioByLoginAndPassword(RequestLogin request) {
		return usuarioRepository.findByEmailAndSenha(request.getEmail(), request.getSenha());
	}
	
	
}
