package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.taikhoanDAO;
import DTO.NhanVienDTO;
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
	
	public taikhoanDTO checkTaiKhoan(String user, String password) {
		try {
			return taikhoanDAO.getIntance().checkTaiKhoan(user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
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
	public NhanVienDTO getNhanVien(String user) {
		try {
			return taikhoanDAO.getIntance().getInfo_NhanVien(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public int change_info(taikhoanDTO tk) {
		try {
			return taikhoanDAO.getIntance().change_Info(tk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateQuyen(taikhoanDTO tk) {
		try {
			for(taikhoanDTO t : tkDTO) 
				if(t.getUser().equals(tk.getUser())) 
					t.copyTK(tk);
			return taikhoanDAO.getIntance().updateQuyen(tk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	public taikhoanDTO getTaikhoan(String user) {
		try {
			return taikhoanDAO.getIntance().getTaikhoan(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int xoaTK(taikhoanDTO tk) {
		try {
			tkDTO.removeIf(v -> v.getUser().equals(tk.getUser()));
			return taikhoanDAO.getIntance().deleteTaiKhoan(tk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	} 
	
	public int themTK(taikhoanDTO tk) {
		try {
			for(taikhoanDTO t: tkDTO) {
				if(tk.getUser().equals(t.getUser())) {
					JOptionPane.showMessageDialog(null, "Tài khoản" + tk.getUser() +" đã tồn tại");
					return -1;
				}
			}
				tkDTO.add(tk);
			return taikhoanDAO.getIntance().Insert_TaiKhoan(tk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public String getMaQuyen(String tenquyen) {
		try {
			return taikhoanDAO.getIntance().getMaQuyen(tenquyen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
