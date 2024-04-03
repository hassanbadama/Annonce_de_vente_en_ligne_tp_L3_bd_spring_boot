package app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.com.entite.Annonce;

public interface AnnonceReposiyory extends JpaRepository<Annonce, String> {

}
