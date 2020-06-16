package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@CrossOrigin
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required=false, value="codePostal") String nomParam) {
		System.out.println("Appel GET");

		ArrayList<Ville> listeVilles = villeBLOService.getInfoVille(nomParam);

		return listeVilles;
	}
	
	// Methode POST
	@CrossOrigin
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public boolean appelPost(@RequestBody Ville ville) {
		System.out.println("Appel POST");
		
		boolean villePost = villeBLOService.getInfoVillePost(ville);
		
		return villePost;
	}
	
	// Methode Put
	@CrossOrigin
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public boolean appelPut(@RequestBody Ville ville) {
		System.out.println("Appel PUT");
		
		boolean villePut = villeBLOService.getInfoVillePut(ville);
		
		return villePut;
	}
		
	// Methode Delete
	@CrossOrigin
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean appelDelete(@RequestBody Ville ville) {
		System.out.println("Appel DELETE");
		
		boolean villeDelete = villeBLOService.getInfoVilleDelete(ville);
		
		return villeDelete;
	}
}
