package app.com.entite;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commande {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prix;
	private String adresseAlivraison;
	
	 @ManyToOne
	 @JoinColumn(name="acheteur")
	 private Acheteur acheteur;
	 @ManyToOne
	 @JoinColumn(name="annonce")
	 private Annonce annonce;
	 @ManyToOne
	 @JoinColumn(name="idVendeur")
	 private Vendeur idVendeur;
	 
	@OneToMany(mappedBy="commande", fetch=FetchType.LAZY)
	 private Collection<Paiement> paiement;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(String prix, String adresseAlivraison, Acheteur acheteur, Annonce annonce, Vendeur idVendeur,
			Collection<Paiement> paiement) {
		super();
		this.prix = prix;
		this.adresseAlivraison = adresseAlivraison;
		this.acheteur = acheteur;
		this.annonce = annonce;
		this.idVendeur = idVendeur;
		this.paiement = paiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getAdresseAlivraison() {
		return adresseAlivraison;
	}

	public void setAdresseAlivraison(String adresseAlivraison) {
		this.adresseAlivraison = adresseAlivraison;
	}

	public Acheteur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Vendeur getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(Vendeur idVendeur) {
		this.idVendeur = idVendeur;
	}

	public Collection<Paiement> getPaiement() {
		return paiement;
	}

	public void setPaiement(Collection<Paiement> paiement) {
		this.paiement = paiement;
	}
	

}
