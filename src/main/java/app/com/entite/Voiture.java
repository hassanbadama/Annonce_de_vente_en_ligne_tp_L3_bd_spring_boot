package app.com.entite;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Voiture {
	@Id
	 private String matricule;
	 private String typeMoteur;
	 private String imageVoiture;
	 @OneToMany(mappedBy="idVoiture", fetch=FetchType.LAZY)
	 private Collection<Annonce> annonce;
	 @ManyToOne
	 @JoinColumn(name="model")
	 private ModelVoiture model;
	 
	 public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	 }

	public Voiture(String matricule, String typeMoteur, String imageVoiture,ModelVoiture model) {
		super();
		this.matricule = matricule;
		this.typeMoteur = typeMoteur;
		this.imageVoiture = imageVoiture;
		this.model = model;
		
	}

	public String getImageVoiture() {
		return imageVoiture;
	}

	public void setImageVoiture(String imageVoiture) {
		this.imageVoiture = imageVoiture;
	}


	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getTypeMoteur() {
		return typeMoteur;
	}

	public void setTypeMoteur(String typeMoteur) {
		this.typeMoteur = typeMoteur;
	}

	public Collection<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Collection<Annonce> annonce) {
		this.annonce = annonce;
	}



	public ModelVoiture getModel() {
		return model;
	}



	public void setModel(ModelVoiture model) {
		this.model = model;
	}

	
	 
}
