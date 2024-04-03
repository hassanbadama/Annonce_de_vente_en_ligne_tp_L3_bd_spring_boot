package app.com.entite;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ModelVoiture {
	@Id
	 private String model;
	 private String anne;
	 private String marque;
	 private String vitesse;
	 @OneToMany(mappedBy="model", fetch=FetchType.LAZY)
	 private Collection<Voiture> voiture;

	public ModelVoiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelVoiture(String model,String marque, String vitesse) {
		super();
		this.model = model;
		
		this.marque = marque;
		this.vitesse = vitesse;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAnne() {
		return anne;
	}

	public void setAnne(String anne) {
		this.anne = anne;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getVitesse() {
		return vitesse;
	}

	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	public Collection<Voiture> getVoiture() {
		return voiture;
	}

	public void setVoiture(Collection<Voiture> voiture) {
		this.voiture = voiture;
	}

	
	 
	 

}
