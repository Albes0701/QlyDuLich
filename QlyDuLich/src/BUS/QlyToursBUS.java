package BUS;

import java.util.ArrayList;

import DAO.QlyToursDAO;
import DTO.QlyToursDTO;
import GUI.QuanLyTour;

public class QlyToursBUS {
	QlyToursDAO tourDAO=new QlyToursDAO();
	public ArrayList<QlyToursDTO> docTour(){
		try {
			return tourDAO.getIntance().selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int them(QlyToursDTO t) {
		try {
			return tourDAO.getIntance().InsertTour(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int xoa(QlyToursDTO t) {
		try {
			System.out.println("OK");
			return tourDAO.getIntance().delete(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int sua(QlyToursDTO t) {
		try {
			System.out.println("OK");
			return tourDAO.getIntance().updateTour(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<QlyToursDTO> timkiem(String cond,String condType){
		try {
			return tourDAO.getIntance().selectByCondition(cond, condType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
