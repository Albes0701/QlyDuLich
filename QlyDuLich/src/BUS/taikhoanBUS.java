package BUS;

import java.util.ArrayList;

import DAO.taikhoanDAO;
import DTO.taikhoanDTO;



public class taikhoanBUS {
	public static ArrayList<taikhoanDTO> tkDTO;
	public boolean docTK() {
		try {
			tkDTO = taikhoanDAO.getIntance().selectAll();
			if(tkDTO != null) return true;
			else {
				System.out.println("DU LIEU RONG");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public String getName(String user) {
		try {
			return taikhoanDAO.getIntance().getInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
