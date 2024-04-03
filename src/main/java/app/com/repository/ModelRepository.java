package app.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.com.entite.ModelVoiture;

public interface ModelRepository extends JpaRepository<ModelVoiture, String> {
	List<ModelVoiture> findByModel(String mc);

}
