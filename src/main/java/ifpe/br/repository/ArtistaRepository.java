package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpe.br.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}