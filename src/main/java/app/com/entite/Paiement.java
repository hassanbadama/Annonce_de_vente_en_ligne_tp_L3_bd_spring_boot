package app.com.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Paiement {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 private String modPaiement;
	 
	 @ManyToOne
	 @JoinColumn(name="commande")
	 private Commande commande;

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paiement(String modPaiement, Commande commande) {
		super();
		this.modPaiement = modPaiement;
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModPaiement() {
		return modPaiement;
	}

	public void setModPaiement(String modPaiement) {
		this.modPaiement = modPaiement;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	 
	 

}
