package com.example.springtp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.springtp1.entity.utilisateur;
@Component
public interface UtilisateurRep extends JpaRepository<utilisateur, Long> {
	public Iterable<utilisateur>findByNom(String nom);
		
	public utilisateur findByLoginAndPassword(String login,String password);
}
