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
}
