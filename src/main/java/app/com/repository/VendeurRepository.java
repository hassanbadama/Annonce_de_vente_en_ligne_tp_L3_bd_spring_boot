package app.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.com.entite.ModelVoiture;
import app.com.entite.Vendeur;

public interface VendeurRepository extends JpaRepository<Vendeur,String> {
	List<Vendeur> findByNom(String mc);

}
