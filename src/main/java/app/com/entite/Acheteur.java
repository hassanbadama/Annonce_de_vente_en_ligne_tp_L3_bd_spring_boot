package app.com.entite;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
  
@Entity
public class Acheteur {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String nom;
	private String prenom;
	private String numero;
	private String mail;
	
	@OneToMany(mappedBy="acheteur", fetch=FetchType.LAZY)
	private Collection<Commande> commande;
	
	public Acheteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Acheteur(String nom, String prenom, String numero, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.mail = mail;
	}
	
	

	public Collection<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	
  
}
