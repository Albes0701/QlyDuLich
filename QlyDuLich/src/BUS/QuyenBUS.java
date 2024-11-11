package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.QuyenDAO;
import DTO.QuyenDTO;


public class QuyenBUS {
	public static ArrayList<QuyenDTO> quyenDTO = new ArrayList<QuyenDTO>();
	public boolean docDSQuyen() {
		try {
			quyenDTO = QuyenDAO.getIntance().selectAll();
			if(quyenDTO != null) return true;
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
	
	
	public ArrayList<String> getQuyen() {
		try {
			return QuyenDAO.getIntance().getQuyen();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int themQuyen(QuyenDTO q) {
		try {
			for(QuyenDTO v: quyenDTO) {
				if(v.getMaquyen().equals(q.getMaquyen())) {
					JOptionPane.showMessageDialog(null, "Mã quyền " + q.getMaquyen() +" đã tồn tại");
					return -1;
				}
			}
				quyenDTO.add(q);
			return QuyenDAO.getIntance().InsertQuyen(q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaQuyen(QuyenDTO q) {
		try {
			quyenDTO.removeIf(v -> v.getMaquyen().equals(q.getMaquyen()));
			return QuyenDAO.getIntance().deleteQuyen(q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public int suaQuyen(QuyenDTO q) {
		try {
			for(QuyenDTO t : quyenDTO) {
				if(t.getMaquyen().equals(q.getMaquyen())) {
					t.copyQuyen(q);
					return QuyenDAO.getIntance().upDateQuyen(t);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
}
