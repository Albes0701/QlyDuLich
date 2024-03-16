package BUS;

import java.util.ArrayList;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

public class NhanVienBUS {
	NhanVienDAO nvDAO = new NhanVienDAO();
	public ArrayList<NhanVienDTO> docnv(){
		try {
			return nvDAO.getIntance().selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
}
