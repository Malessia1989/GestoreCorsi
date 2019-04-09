package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.model.Corso;

public class GestoreCorsi {

	public String getCorsiByPeriodo(String periodo) {
		CorsoDAO dao = new CorsoDAO();		
		List<Corso> corsi= new LinkedList<Corso>(dao.listCorsiByPD(Integer.parseInt(periodo)));
		String elencoCorsi=" ";
		for(Corso c:corsi) {
			elencoCorsi+= corsi.toString()+ "\n";
		}
		return elencoCorsi;
	}

	public static boolean isDigit(String pd) {
		
		return pd.matches("\\d{1}");
	}

	public String getNumIScrittibyPeriodo(String pd) {
		CorsoDAO dao= new CorsoDAO();
		return dao.IscrittibyPd(Integer.parseInt(pd));
	}

	

}
