package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listCorsiByPD(int periodo) {
		final String sql= " select * " + 
				"from corso " + 
				"where pd= ? ";
		
		List<Corso> corsi= new LinkedList<Corso>();
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, periodo);
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"), rs.getInt("pd"));
				corsi.add(c);
			}
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return corsi;
	}

	public String IscrittibyPd(int periodo) {
		
		final String sql="select COUNT(matricola) " + 
				"from corso as c,iscrizione as i " + 
				"where c.codins=i.codins and pd=? ";
		
		int iscritti=0;
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, periodo);
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				iscritti =
			}
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return corsi;
		
		return null;
	}



}
