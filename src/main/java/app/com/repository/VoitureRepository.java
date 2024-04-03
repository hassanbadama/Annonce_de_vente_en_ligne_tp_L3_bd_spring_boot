package app.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.com.entite.ModelVoiture;
import app.com.entite.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, String>{
	//List<Voiture> findByModel(String mc);
}
