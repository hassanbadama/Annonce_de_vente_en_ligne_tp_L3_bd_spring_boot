package app.com.entite;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vendeur {
  @Id 
   private String nom;
   private String prenom;
   private String numero;
   private String mail;
   private String sexe;
   @OneToMany(mappedBy="idVendeur", fetch=FetchType.LAZY)
   private Collection<Annonce> annonce;
   @OneToMany(mappedBy="idVendeur", fetch=FetchType.LAZY)
   private Collection<Commande> commande;
   
	public Vendeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendeur(String nom, String prenom, String numero, String mail, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.mail = mail;
		this.sexe = sexe;
	}
	
	
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Collection<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Collection<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Collection<Annonce> annonce) {
		this.annonce = annonce;
	}
	
	
	
	
	
   
   
}
