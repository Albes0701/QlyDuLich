package BUS;

import java.util.ArrayList;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
	HoaDonDAO hoadonDAO=new HoaDonDAO();
	public static ArrayList<HoaDonDTO> listHD=new ArrayList<HoaDonDTO>();
	public boolean docHoaDon(){
		try {
			listHD= hoadonDAO.getIntance().selectAll();
			if(listHD!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int them(HoaDonDTO t) {
		try {
			listHD.add(t);
			return hoadonDAO.getIntance().InsertHoaDon(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
