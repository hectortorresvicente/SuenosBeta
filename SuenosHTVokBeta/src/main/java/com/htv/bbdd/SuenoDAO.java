package com.htv.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.htv.models.Sueno;



public class SuenoDAO extends DAO {

	private static SuenoDAO instance = null;

	public static SuenoDAO getInstance() throws Exception {
		if (instance == null)
			instance = new SuenoDAO();

		return instance;
	}

	private SuenoDAO() throws Exception {
	}

	public List<Sueno> getLista() {

		List<Sueno> resultado = new ArrayList<Sueno>();

		try {
			System.out.println("1 estoy en el DAO ="  );

			Connection conn = DriverManager.getConnection(url);

			String query =  ("SELECT titulo FROM sueno WHERE ids=3");
			
			System.out.println(" 2estoy en el servlet con la info DAO buscando ="  + resultado );

			PreparedStatement stmt = conn.prepareStatement(query);
	

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				resultado.add(new Sueno( rs.getString("titulo")));

			}
			System.out.println(" 3 estoy en el servlet con la info DAO despues de buscar ="  + resultado.size() );

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public Sueno getCity(String cityId) {
		Sueno unaCiudad = null;
		try {
			Connection conn = DriverManager.getConnection(url);

			String query = ("SELECT * FROM city WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, cityId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
//				unaCiudad = new Sueno(rs.getInt("id"), rs.getString("name"), rs.getString("countryCode"),
//						rs.getString("district"), rs.getInt("population")
//
//				);

				break;
			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return unaCiudad;
	}

	public boolean updateCity(Sueno cityToUpdate) {

		boolean result = false;

		try {
			Connection conn = DriverManager.getConnection(url);

			String query = ("UPDATE city SET name=?,  countryCode=?, district=?, population=? WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
//			stmt.setString(1, cityToUpdate.getName());
//			stmt.setString(2, cityToUpdate.getCountryCode());
//			stmt.setString(3, cityToUpdate.getDistrict());
//			stmt.setInt(4, cityToUpdate.getPopulation());
//			stmt.setInt(5, cityToUpdate.getId());

			int isOk = stmt.executeUpdate();

			result = true;

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

//	public int add(Sueno cityToAdd) {
//		int resultId = 0;

//		try {
//			Connection conn = DriverManager.getConnection(url);
//			String query = ("INSERT INTO city (name,countryCode,district,population) VALUES (?,?,?,?)");

//			PreparedStatement stmt = conn.prepareStatement(query);
//			stmt.setString(1, cityToAdd.getName());
//			stmt.setString(2, cityToAdd.getCountryCode());
//			stmt.setString(3, cityToAdd.getDistrict());
//			stmt.setInt(4, cityToAdd.getPopulation());
//
//			System.out.println("Query:" + stmt.toString());
//
//			stmt.executeUpdate();
//			ResultSet rs = stmt.getGeneratedKeys();
//
//			while (rs.next()) {
//				resultId = rs.getInt(1);
//			}
//
//			stmt.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return resultId;
//	}

	public boolean deleteCity(int cid) {
		boolean result=false;
		try {
			Connection conn = DriverManager.getConnection(url);
			String query = ("DELETE FROM city WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, cid);
			stmt.executeUpdate();
			
			result=true;
			stmt.close();
			conn.close();
		} catch (Exception e) {

		}

		return result;
	}

}

