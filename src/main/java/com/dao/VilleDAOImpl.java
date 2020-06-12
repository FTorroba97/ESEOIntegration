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
		Ville ville1 = null;
		
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
}
