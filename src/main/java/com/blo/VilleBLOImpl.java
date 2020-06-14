package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVille(String param) {
		ArrayList<Ville> listeVilles;
		
		listeVilles = villeDAO.findAllVilles(param);
		
		return listeVilles;
	}
	
	public boolean getInfoVillePost(Ville ville) {
		boolean villePost;
		
		villePost = villeDAO.postVille(ville);
		
		return villePost;
	}
	
	public boolean getInfoVillePut(Ville villeOld, Ville villeNew) {
		boolean villePut;
		
		villePut = villeDAO.putVille(villeOld, villeNew);
		
		return villePut;
	}
	
	public boolean getInfoVilleDelete(Ville ville) {
		boolean villeDelete;
		
		villeDelete = villeDAO.deleteVille(ville);
		
		return villeDelete;
	}
}
