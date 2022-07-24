package ifpe.br.mappers;

import org.springframework.stereotype.Component;

import ifpe.br.model.Artista;
import ifpe.br.model.dto.ArtistaDTO;

@Component
public class ArtistaDTOMapper {

	public ArtistaDTO map(Artista artista) {
		
		ArtistaDTO artistaDTO = new ArtistaDTO();
		artistaDTO.setId(artista.getId());
		artistaDTO.setNomeCompleto(artista.getNomeCompleto());
		artistaDTO.setEmail(artista.getEmail());
		artistaDTO.setDtNascimento(artista.getDtNascimento());
		artistaDTO.setCelular(artista.getCelular());
		
		return artistaDTO;
	}

}
