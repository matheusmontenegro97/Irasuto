package ifpe.br.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.mappers.ArtistaDTOMapper;
import ifpe.br.model.Artista;
import ifpe.br.model.InfoArtista;
import ifpe.br.model.PasswordArtista;
import ifpe.br.model.dto.ArtistaDTO;
import ifpe.br.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	ArtistaRepository artistaRepository;

	@Autowired
	ArtistaDTOMapper mapper;

	public ArtistaDTO createArtista(Artista artista) {
		Artista artistaSaved = artistaRepository.save(artista);

		return mapper.map(artistaSaved);
	}

	public List<ArtistaDTO> retornaTodosArtistas() {
		List<Artista> artistas = artistaRepository.findAll();
		List<ArtistaDTO> artistasDTO = new ArrayList<>();

		artistas.forEach(artista -> artistasDTO.add(mapper.map(artista)));

		return artistasDTO;

	}

	public ArtistaDTO retornaArtistaPorId(UUID id) throws Exception {
		Artista artista = artistaRepository.findById(id)
				.orElseThrow(() -> new Exception("Artista não encontrado com id: " + id));

		return mapper.map(artista);
	}

	public ArtistaDTO retornaArtistaPorEmailAndSenha(String email, String password) throws Exception{
		Artista artista = artistaRepository.findByEmailAndSenha(email, password)
				.orElseThrow(() -> new Exception("E-mail ou senha estão incorretos!"));;
		return mapper.map(artista);
		}
	
	@Transactional
	public ArtistaDTO atualizaArtista(UUID id, InfoArtista infoArtista) throws Exception {
		Artista artista = artistaRepository.findById(id)
				.orElseThrow(() -> new Exception("Artista não encontrado com id: " + id));
		

		artista.setNomeCompleto(infoArtista.getNomeCompleto());
		artista.setDtNascimento(infoArtista.getDtNascimento());
		artista.setEmail(infoArtista.getEmail());
		artista.setCelular(infoArtista.getCelular());
		
		Artista artistaSaved = artistaRepository.save(artista);

		return mapper.map(artistaSaved);

	}
	
	@SuppressWarnings("unused")
	@Transactional
	public String atualizaSenha(UUID id, PasswordArtista passwordArtista) throws Exception {
		Artista artista = artistaRepository.findById(id)
				.orElseThrow(() -> new Exception("Artista não encontrado com id: " + id));
		
		artista.setSenha(passwordArtista.getSenha());
		
		Artista artistaSaved = artistaRepository.save(artista);
		String message = "Senha atualizada com sucesso!";

		return message;

	}

	public void deletaArtista(UUID id) throws Exception {
		Artista artista = artistaRepository.findById(id)
				.orElseThrow(() -> new Exception("Artista não encontrado com id: " + id));
		artistaRepository.deleteById(artista.getId());
	}
}
