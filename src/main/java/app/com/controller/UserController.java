package app.com.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import app.com.repository.AnnonceReposiyory;
import app.com.repository.ModelRepository;
import app.com.repository.VendeurRepository;
import app.com.repository.VoitureRepository;
import app.com.entite.*;


@Controller
public class UserController {
	@Autowired
	private VoitureRepository repoVoiture;
	@Autowired
	private VendeurRepository vendeurRpo;
	@Autowired
	private ModelRepository modelrepo;
	@Autowired
	private AnnonceReposiyory annonceRop;
	
	@GetMapping(path="/admin")
	public String connexion(Model model) {
		return "Connexion";
	}
	@PostMapping(path="/connecter")
	public String Connecter(Model model, String nom) {
		
		try {
			 Vendeur p=vendeurRpo.findById(nom).get();
			 model.addAttribute("p",p);
			 return "pageAdmin";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "redirect:/admin";
		}
		
	}
	
	
	@GetMapping(path="/accueil")
	public String accueil(Model model) {
		List<Voiture>v = repoVoiture.findAll();
	    model.addAttribute("v",v);
		List<ModelVoiture>mode = modelrepo.findAll();
		model.addAttribute("mode",mode);
		List<Vendeur>vendeur = vendeurRpo.findAll();
		model.addAttribute("vendeur",vendeur);
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		return "index";
	}
	
	@GetMapping(path="/consulter")
	public String consulter(Model model) {
		List<Voiture>v = repoVoiture.findAll();
	    model.addAttribute("v",v);
		List<ModelVoiture>mode = modelrepo.findAll();
		model.addAttribute("mode",mode);
		List<Vendeur>vendeur = vendeurRpo.findAll();
		model.addAttribute("vendeur",vendeur);
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		return "AfficherArticle";
	}
	
	@GetMapping(path="/voiture")
	public String ajoutervoiture(Model model) {
		List<Voiture>v = repoVoiture.findAll();
	    model.addAttribute("v",v);
		List<ModelVoiture>mode = modelrepo.findAll();
		model.addAttribute("mode",mode);
		List<Vendeur>vendeur = vendeurRpo.findAll();
		model.addAttribute("vendeur",vendeur);
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		return "Voiture";
	}
	
	@GetMapping(path="/rechercheVoiture")
	public String recherch(Model model) {
		List<Voiture>voiture = repoVoiture.findAll();
	    model.addAttribute("voiture",voiture);
		
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		return "RechercheVoiture";
	}
	
	
	@PostMapping(path="/rechercheVoiture")
	public String rechercherVoiture(Model model,String voiture1) {
		
		List<ModelVoiture>mod = modelrepo.findByModel(voiture1);
		mod.forEach(p->{
			Collection<Voiture> voiture=p.getVoiture();
			voiture.forEach(p2->{
				System.out.println("matricule"+p2.getMatricule());
			});
			model.addAttribute("voiture",voiture);
			System.out.println("codetese"+voiture1);
		});
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		return "RechercheVoiture";
	}
	
	@PostMapping(path="/AjouterVoiture")
	public String AjouterProf(@RequestParam MultipartFile image,String matricule,String modele, String nom,String moteur,String description, String prix,String vendeur  ) {
		System.out.println("image "+image.getOriginalFilename());
		System.out.println("matricule-"+matricule +" nom="+nom+" mode="+modele+" moteur ="+moteur+" description ="+description+" prix="+prix+" vendeur="+vendeur);
		//ModelVoiture mdel = new ModelVoiture(model,"2443","35535","332");
		ModelVoiture mod =modelrepo.findById(modele).get();
		Voiture voiture=new Voiture (matricule,moteur,image.getOriginalFilename(),mod);
		repoVoiture.save(voiture);
		Vendeur vendeur1=vendeurRpo.findById(vendeur).get();
		Annonce annonce = new Annonce(matricule,description, prix, voiture,
				vendeur1);
		annonceRop.save(annonce);
		Voiture voiture1=repoVoiture.save(voiture);
		if(voiture!=null) {
			try {
				File saveFile=new ClassPathResource("static/img").getFile();
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+image.getOriginalFilename());
			    Files.copy(image.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/voiture";
	}
	
	
	@GetMapping(path="/modifierVoiture")
	public String modifierVoiture(Model model,String id) {
		//int not=Integer.parseInt(id);
	    Annonce p=annonceRop.findById(id).get();
		model.addAttribute("p",p);
		List<Annonce>annonce = annonceRop.findAll();
		model.addAttribute("annonce",annonce);
		List<ModelVoiture>mode = modelrepo.findAll();
		model.addAttribute("mode",mode);
		List<Vendeur>vendeur = vendeurRpo.findAll();
		model.addAttribute("vendeur",vendeur);
		return "ModifierVoiture";
	}
	
	@GetMapping(path="/supprimerVoiture")
	public String SupprimerProfesseur(String id) {
		annonceRop.deleteById(id);
		repoVoiture.deleteById(id);
		return "redirect:/voiture";
	}
	
	
	@GetMapping(path="/rechercherVendeur")
	public String RechercherVendeur(Model model) {
		List<Vendeur>vendeur = vendeurRpo.findAll();
	    model.addAttribute("vendeur",vendeur);
		return "RechercherVendeur";
	}
	@PostMapping(path="/rechercheVendeur")
	public String Rechervendeur(Model model,String nom) {
		//Vendeur vendeur = new Vendeur(nom,prenom,numero,mail,sexe);
		
		List<Vendeur>vendeur = vendeurRpo.findByNom(nom);
	    model.addAttribute("vendeur",vendeur);
		return "RechercherVendeur";
	}
	
	@GetMapping(path="/vendeur")
	public String ajouterVendeur(Model model) {
		List<Vendeur>vendeur = vendeurRpo.findAll();
	    model.addAttribute("vendeur",vendeur);
		return "Vendeur";
	}
	@PostMapping(path="/AjouterVendeur")
	public String Ajoutevendeur(Model model,String nom,String sexe,String prenom, String numero,String mail) {
		Vendeur vendeur = new Vendeur(nom,prenom,numero,mail,sexe);
		vendeurRpo.save(vendeur);
		return "redirect:/vendeur";
	}
	@GetMapping(path="/modifierVendeur")
	public String modifierVendeur(Model model,String id) { 
		//int not=Integer.parseInt(id);
	    Vendeur p=vendeurRpo.findById(id).get();
		model.addAttribute("p",p);
		List<Vendeur>vendeur = vendeurRpo.findAll();
	    model.addAttribute("vendeur",vendeur);
		return "ModifierVendeur";
	}
	@GetMapping(path="/supprimerVendeur")
	public String SupprimerVendeur(Model model, String id) {
		
		try {
			vendeurRpo.deleteById(id);
			return "redirect:/model";
		}
		catch(Exception e) {
			List<Vendeur>vendeur = vendeurRpo.findAll();
		    model.addAttribute("vendeur",vendeur);
			String erreur="";
			erreur="Pour supprimer le vendeur il faut supprimer d'abord les annonce qu'il a cere";
			model.addAttribute("erreur",erreur);
			return "Vendeur";
		}
	}
	
	
	
	@GetMapping(path="/model")
	public String ajouterMdel(Model model) {
		List<ModelVoiture>mode = modelrepo.findAll();
	    model.addAttribute("mode",mode);
		//List<Matiere>codematiere = matiereRepository.findAll();
		//model.addAttribute("codematiere",codematiere);*/
		
		return "Model";
	}
	@PostMapping(path="/AjouterModel")
	public String Ajoutemodel(Model model,String mode,String marque, String vitesse) {
		ModelVoiture mod = new ModelVoiture(mode,marque,vitesse);
		modelrepo.save(mod);
		return "redirect:/model";
	}
	@GetMapping(path="/modifierModel")
	public String modifierModel(Model model,String id) { 
		//int not=Integer.parseInt(id);
		ModelVoiture p=modelrepo.findById(id).get();
		model.addAttribute("p",p);
		List<ModelVoiture>mode = modelrepo.findAll();
	    model.addAttribute("mode",mode);
	    
		return "modifierModel";
	}
	@GetMapping(path="/supprimerModel")
	public String SupprimerModel(Model model, String id) {
		
		try {
			modelrepo.deleteById(id);
			return "redirect:/model";
		}
		catch(Exception e) {
			List<ModelVoiture>mode = modelrepo.findAll();
		    model.addAttribute("mode",mode);
			String erreur="";
			erreur="Pour supprimer le model il faut supprimer d'abord les voitures de ce model";
			 model.addAttribute("erreur",erreur);
			return "Model";
		}
		//return "redirect:/model";
	}

}
