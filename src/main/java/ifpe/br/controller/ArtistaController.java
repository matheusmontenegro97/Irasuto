package ifpe.br.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Artista;
import ifpe.br.model.InfoArtista;
import ifpe.br.model.PasswordArtista;
import ifpe.br.model.dto.ArtistaDTO;
import ifpe.br.service.ArtistaService;

@RestController
@RequestMapping("/api/v1")
public class ArtistaController {
	
	@Autowired
	ArtistaService artistaService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/artistas")
	public ResponseEntity<List<ArtistaDTO>> retornaArtistas(){
		return ResponseEntity.status(HttpStatus.OK).body(artistaService.retornaTodosArtistas());
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/artista/{id}")
	public ResponseEntity<ArtistaDTO> retornaArtistaById(@PathVariable(value = "id") UUID id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(artistaService.retornaArtistaPorId(id));
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/login/artista")
	public ResponseEntity<ArtistaDTO> retornaArtistaByEmailAndSenha(String email, String senha) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(artistaService.retornaArtistaPorEmailAndSenha(email, senha));
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/atualiza_artista/{id}")
	public ResponseEntity<ArtistaDTO> atualizaArtistaById(@PathVariable(value = "id") UUID id,@RequestBody InfoArtista infoArtista) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(artistaService.atualizaArtista(id, infoArtista));
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/atualiza_senha/{id}")
	public ResponseEntity<String> atualizaSenhaById(@PathVariable(value = "id") UUID id,@RequestBody PasswordArtista password) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(artistaService.atualizaSenha(id, password));
	}
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/deleta_artista/{id}")
	public void deletaArtista(@PathVariable(value = "id") UUID id) throws Exception {
		 artistaService.deletaArtista(id);
	}

	@PostMapping("/criaArtista")
	public ResponseEntity<ArtistaDTO> createArtista(@RequestBody Artista artista) {
		return ResponseEntity.status(HttpStatus.CREATED).body(artistaService.createArtista(artista));
	}
}
