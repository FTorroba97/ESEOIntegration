package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles(String param) {
		ArrayList<Ville> listeVilles = new ArrayList<Ville>();
		
		Connection con = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		
		String requete;
		if (param == null) {
			requete = "SELECT * FROM ville_france";
		} else {
			requete = "SELECT * FROM ville_france WHERE Code_postal='" + param + "'";
		}

		try {
		   Statement stmt = con.createStatement();
		   results = stmt.executeQuery(requete);
		   
		   while (results.next()) {
			   Ville ville = new Ville();
			   ville.setCodeCommune(results.getString(1));
			   ville.setNomCommune(results.getString(2));
			   ville.setCodePostal(results.getString(3));
			   ville.setLibelleAcheminement(results.getString(4));
			   ville.setLigne(results.getString(5));
			   listeVilles.add(ville);
			   System.out.println("rep : " + results.getString("Nom_commune"));
		   }

		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return listeVilles;
	}
	
	public boolean postVille(Ville ville) {
		boolean villePost = false;
		
		Connection con = JDBCConfiguration.getConnection();
		
		String requete = "INSERT INTO 'ville_france' ('Code_commune_INSEE', 'Nom_commune', 'Code_postal', 'Libelle_acheminement', 'Ligne_5', 'Latitude', 'Longitude') VALUES ('" + ville.getCodeCommune() + "', '" + ville.getNomCommune() + "', '" + ville.getCodePostal() + "', '" + ville.getLibelleAcheminement() + "', '" + ville.getLibelleAcheminement() + "', '" + ville.getLatitude() + "', '" + ville.getLongitude() + "');";

		try {
		   Statement stmt = con.createStatement();
		   int results = stmt.executeUpdate(requete);
		   villePost = (results > 0);
		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return villePost;
	}
	
	public boolean putVille(Ville villeOld, Ville villeNew) {
		boolean villePut = false;
		
		Connection con = JDBCConfiguration.getConnection();
		
		String requete = "UPDATE 'ville_france' SET 'Code_commune_INSEE' = '" + villeNew.getCodeCommune() + "', 'Nom_commune' = '" + villeNew.getNomCommune() + "', 'Code_postal' = '" + villeNew.getCodePostal() + "', 'Libelle_acheminement' = '" + villeNew.getLibelleAcheminement() + "', 'Ligne_5' = '" + villeNew.getLigne() + "', 'Latitude' = '" + villeNew.getLatitude() + "', 'Longitude' = '" + villeNew.getLongitude() + "' WHERE 'Code_commune_INSEE' = '" + villeOld.getCodeCommune() + "';";

		try {
			Statement stmt = con.createStatement();
			int results = stmt.executeUpdate(requete);
			villePut = (results > 0);

		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return villePut;
	}
	
	public boolean deleteVille(Ville ville) {
		boolean villeDelete = false;
		
		Connection con = JDBCConfiguration.getConnection();
		
		String requete = "DELETE FROM 'ville_france' WHERE 'Code_commune_INSEE' = '" + ville.getCodeCommune() + "';";

		try {
			Statement stmt = con.createStatement();
			int results = stmt.executeUpdate(requete);
			villeDelete = (results > 0);
		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return villeDelete;
	}
}
