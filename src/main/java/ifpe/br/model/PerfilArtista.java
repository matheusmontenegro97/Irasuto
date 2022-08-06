package ifpe.br.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PerfilArtista {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID codigoArtista;
	private String[] portfolioArtista;
	private String descricaoProfissional;

	public UUID getCodigoArtista() {
		return codigoArtista;
	}

	public void setCodigoArtista(UUID codigoArtista) {
		this.codigoArtista = codigoArtista;
	}

	public String[] getPortfolioArtista() {
		return portfolioArtista;
	}

	public void setPortfolioArtista(String[] portfolioArtista) {
		this.portfolioArtista = portfolioArtista;
	}

	public String getDescricaoProfissional() {
		return descricaoProfissional;
	}

	public void setDescricaoProfissional(String descricaoProfissional) {
		this.descricaoProfissional = descricaoProfissional;
	}

}
