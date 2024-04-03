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
public class Annonce {
	
	@Id 
	   private String id;
	   private String tire;
	   private String description;
	   private String prix;
	   @ManyToOne
		@JoinColumn(name="idVoiture")
	   private Voiture idVoiture;
	   @ManyToOne
		@JoinColumn(name="idVendeur")
	   private Vendeur idVendeur;
	   
	   @OneToMany(mappedBy="annonce", fetch=FetchType.LAZY)
		private Collection<Commande> commande;
	   
		public Annonce() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		

		public Annonce(String id, String description, String prix, Voiture idVoiture, Vendeur idVendeur) {
			super();
			this.id = id;
			this.description = description;
			this.prix = prix;
			this.idVoiture = idVoiture;
			this.idVendeur = idVendeur;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Collection<Commande> getCommande() {
			return commande;
		}
		public void setCommande(Collection<Commande> commande) {
			this.commande = commande;
		}
		public String getTire() {
			return tire;
		}

		public void setTire(String tire) {
			this.tire = tire;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPrix() {
			return prix;
		}

		public void setPrix(String prix) {
			this.prix = prix;
		}

		public Voiture getIdVoiture() {
			return idVoiture;
		}

		public void setIdVoiture(Voiture idVoiture) {
			this.idVoiture = idVoiture;
		}

		public Vendeur getIdVendeur() {
			return idVendeur;
		}

		public void setIdVendeur(Vendeur idVendeur) {
			this.idVendeur = idVendeur;
		}
		
		
	   
	   
	   
}
