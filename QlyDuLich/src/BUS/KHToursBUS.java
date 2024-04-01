package BUS;

import java.util.ArrayList;

import DAO.KHTourDAO;
import DTO.KHTourDTO;

public class KHToursBUS {
	public static ArrayList<KHTourDTO> khtList=new ArrayList<KHTourDTO>();
	KHTourDAO khtDAO=new KHTourDAO();
	public boolean docKHT() {
		khtList=khtDAO.getIntance().selectAll();
		if(khtList!=null) {
			return true;
		}
		return false;
	}
	public boolean themKHT(KHTourDTO kht) {
		if(khtDAO.getIntance().InsertKHT(kht)!=0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
}
