package com.example.springtp1.interfaces;

import java.util.List;

import com.example.springtp1.entity.utilisateur;

public interface utilisateurinterface {
//methode pour ajouter
public utilisateur ajouter (utilisateur u) ;
	
//methode pour rechercher
public utilisateur rechercherparid(Long id) ;
	  
//methode pour lister
public List<utilisateur> afficher();
//methode pour supprimer


public void supprimer(long id);
//recherche par nom
public Iterable<utilisateur> rechercherparnom(String nom);

//connexion
public utilisateur connexion(String login,String password);
}


