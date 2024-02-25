package com.example.springtp1.interfaces;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtp1.entity.utilisateur;
import com.example.springtp1.repository.UtilisateurRep;


@Service
public class UtilisateurServ implements utilisateurinterface {
	@Autowired
	private UtilisateurRep ur;
	@Override
	public utilisateur ajouter(utilisateur u) {
		if (u.getId()==0) {
			return ur.save(u);
		}else {
			utilisateur um=ur.findById(u.getId()).get();
			um.setPrenom(u.getPrenom());
			um.setNom(u.getNom());
			um.setLogin(u.getLogin());
			um.setPassword(u.getPassword());
			return ur.save(um);
		}
		
		
	}

	@Override
	public utilisateur rechercherparid(Long id) {
		Optional <utilisateur> opt=ur.findById(id);
		utilisateur u=null;
		if(opt.isPresent()) {
			u=opt.get();
		}else {
			throw new RuntimeException("login ou password incorrect"+ id);
		}
		return u;
		
	}

	@Override
	public List<utilisateur> afficher() {	
		return ur.findAll();
	}

	

	@Override
	public void supprimer(long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

	@Override
	public Iterable<utilisateur> rechercherparnom(String nom) {
		// TODO Auto-generated method stub
		
		return ur.findByNom(nom);
	}

	@Override
	public utilisateur connexion(String login, String password) {
		
		 Optional<utilisateur> opt=Optional.ofNullable(ur.findByLoginAndPassword(login, password));
		 utilisateur u=null;
		 if(opt.isPresent()) {
			 u=opt.get();
		 }else {
			 throw new RuntimeException("login ou mot de passe incorrect");
		 }
		 return u;
	}
	
}
