package ifpe.br.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.PerfilArtista;
import ifpe.br.repository.PerfilArtistaRepository;

@Service
public class PerfilArtistaService {

	@Autowired
	PerfilArtistaRepository repository;
	
	@Autowired
	ArtistaService artistaService;
	
	public PerfilArtista createPerfilArtista(PerfilArtista perfilArtista) throws Exception {
		artistaService.retornaArtistaPorId(perfilArtista.getCodigoArtista());
		
		return repository.save(perfilArtista);
	}
	
	public PerfilArtista getPerfilArtistaById(UUID codigoArtista) throws Exception{	
		PerfilArtista perfilArtista = repository.findById(codigoArtista)
				.orElseThrow(() -> new Exception("Artista não encontrado com codigo: " + codigoArtista));
		
		return perfilArtista;
	}
	
}
