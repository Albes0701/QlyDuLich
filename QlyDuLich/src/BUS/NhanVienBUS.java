package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

public class NhanVienBUS {
	public static ArrayList<NhanVienDTO> nvDTO;
	public boolean docNV() {
		try {
			nvDTO = NhanVienDAO.getIntance().selectAll();
			if(nvDTO != null) return true;
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
	
	public int themDSNV(ArrayList<NhanVienDTO> listNV) {
		try {
			for(NhanVienDTO v: nvDTO) {
				for(NhanVienDTO t: listNV) {
					if(v.getManv().equals(t.getManv())) {
						JOptionPane.showMessageDialog(null, "Mã nhân viên " + t.getManv() +" đã tồn tại");
						return -1;
					}
				}
			} 
			nvDTO.addAll(listNV);
			return NhanVienDAO.getIntance().Insert_DSNhanVien(listNV);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int themNV(NhanVienDTO nv) {
		try {
			for(NhanVienDTO v: nvDTO) {
				if(v.getManv().equals(nv.getManv())) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên " + nv.getManv() +" đã tồn tại");
					return -1;
				}
			}
				nvDTO.add(nv);
			return NhanVienDAO.getIntance().InsertNhanVien(nv);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaNV(NhanVienDTO nv) {
		try {
			nvDTO.removeIf(v -> v.getManv().equals(nv.getManv()));
			return NhanVienDAO.getIntance().deleteNhanVien(nv);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public int suaNV(NhanVienDTO nv) {
		try {
			for(NhanVienDTO t : nvDTO) {
				if(t.getManv().equals(nv.getManv())) {
					t.copyNhanVien(nv);
					return NhanVienDAO.getIntance().upDateNhanVien(t);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<NhanVienDTO> timKiem(String condition, String type){
		ArrayList<NhanVienDTO> tmp = new ArrayList<NhanVienDTO>();
		try {
			if(type.equalsIgnoreCase("Mã số")) {
				for(NhanVienDTO nv : nvDTO) {
					if(nv.getManv().equals(condition)) {
						tmp.add(nv);
					}
				}
			}
			else if(type.equalsIgnoreCase("Họ Tên")) {
				condition = KiemTra.getInstance().formatchString(condition);
				for(NhanVienDTO nv : nvDTO) {
					String name = (nv.getHonv().concat(" ").concat(nv.getTennv())).toLowerCase();
					if(name.contains(condition)) {
						tmp.add(nv);
					}
				}
			}
			else if(type.equalsIgnoreCase("Tên")) {
				condition = KiemTra.getInstance().formatchString(condition);
				for(NhanVienDTO nv : nvDTO) {
					String name = nv.getTennv().toLowerCase();
					if(name.contains(condition)) {
						tmp.add(nv);
					}
				}
			}
			else if(type.equalsIgnoreCase("Ngày vào làm")) {
				if(KiemTra.getInstance().forMatchDate(condition))
				{
					Date ngayVl = KiemTra.getInstance().toDate(condition);
					for(NhanVienDTO nv : nvDTO) {
						if(nv.getNgayvl().equals(ngayVl)) {
							tmp.add(nv);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Dinh dang dung: YYYY-MM-DD");
					return null;
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tmp;
	}
}
