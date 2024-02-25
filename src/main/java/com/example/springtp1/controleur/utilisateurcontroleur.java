package com.example.springtp1.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springtp1.entity.utilisateur;
import com.example.springtp1.interfaces.UtilisateurServ;


@Controller

public class utilisateurcontroleur {

	@Autowired
	UtilisateurServ us;
	
	@GetMapping("/")
	public String Homepage(Model model) {
		model.addAttribute("utilisateur",new utilisateur());
		return "admin/auth/welcome";
	}
	@GetMapping("/newUser")
	public String showPageAjout(Model model) {
		utilisateur utilisateur=new utilisateur();
		model.addAttribute("utilisateur",utilisateur);
		return "admin/auth/newUser";
	}

	@PostMapping("/newUser/save")
	public String AjouterUser(@ModelAttribute("utilisateur") utilisateur utilisateur,BindingResult result,Model model) {
		us.ajouter(utilisateur);
		return "redirect:/newUser?success";
	}
	
}
