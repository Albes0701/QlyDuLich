package BUS;

import java.util.ArrayList;

import DAO.CT_Quyen_ChucNang_DAO;
import DTO.CT_Quyen_ChucNang_DTO;


public class CTQuyenBUS {
	public static ArrayList<CT_Quyen_ChucNang_DTO> CT_Quyen_DTO = new ArrayList<CT_Quyen_ChucNang_DTO>();
	public boolean docDSQuyen(String maquyen) {
		try {
			CT_Quyen_DTO = CT_Quyen_ChucNang_DAO.getIntance().select(maquyen);
			if(CT_Quyen_DTO != null) return true;
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
	
	
	
	public int capnhatCTQuyen(ArrayList<CT_Quyen_ChucNang_DTO> q) {
		try {
			CT_Quyen_ChucNang_DAO.getIntance().deleteQuyen_ChucNang(q.get(0).getMaquyen());
			return CT_Quyen_ChucNang_DAO.getIntance().InsertQuyen_ChucNang(q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<String> selectChucNang(String maquyen){
		try {
			return CT_Quyen_ChucNang_DAO.getIntance().selectChucNang(maquyen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
