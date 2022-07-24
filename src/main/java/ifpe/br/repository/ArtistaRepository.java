package ifpe.br.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, UUID> {
	Optional<Artista> findByEmail(String email);
}