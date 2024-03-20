package BUS;

import java.util.ArrayList;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
    public static  ArrayList<KhachHangDTO> khDTO;
	public KhachHangBUS() {
		// TODO Auto-generated constructor stub
	}
public boolean docKH() {
	try {
		
		khDTO = KhachHangDAO.getIntance().selectAll();
		if(khDTO != null) return true;
		else {
			System.out.println("Du lieu rong");
			return false;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	
}

public int xoaKh(KhachHangDTO kh) {
	try {
		
		khDTO.removeIf(v -> v.getMakh().equals(kh.getMakh()));
		return KhachHangDAO.getIntance().deleteKhachHang(kh);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return -1;
}
}
