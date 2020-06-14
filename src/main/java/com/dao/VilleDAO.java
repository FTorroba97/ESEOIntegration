package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles(String param);
	
	public boolean postVille(Ville ville);
	
	public boolean putVille(Ville villeOld, Ville New);
	
	public boolean deleteVille(Ville ville);

}
