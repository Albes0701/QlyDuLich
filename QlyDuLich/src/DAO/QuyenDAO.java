package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.QuyenDTO;
import Util.JDBCUtil;


public class QuyenDAO {
	public static QuyenDAO getIntance() {
		return new QuyenDAO();
	}
	public ArrayList<QuyenDTO> selectAll() {
		ArrayList<QuyenDTO> ketQua=new ArrayList<QuyenDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM quyen";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String maquyen=rs.getString("maquyen");
				String tenquyen=rs.getString("tenquyen");
				QuyenDTO q= new QuyenDTO(maquyen, tenquyen);
				ketQua.add(q);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<String> getQuyen(){
		ArrayList<String> ketQua=new ArrayList<String>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT tenquyen FROM quyen";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String tenquyen=rs.getString("tenquyen");
				ketQua.add(tenquyen);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public int InsertQuyen(QuyenDTO q) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO quyen (maquyen, tenquyen) VALUES ('"
		            + q.getMaquyen().toLowerCase() + "' , '" + q.getTenquyen() + "')";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		
		return kq;
	}
	public int upDateQuyen(QuyenDTO q) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE quyen SET tenquyen='"
					+ q.getTenquyen() + "' WHERE maquyen = '" + q.getMaquyen() +"';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	
	
	public int deleteQuyen(QuyenDTO q) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM quyen WHERE maquyen = '" + q.getMaquyen() + "'";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
}
