package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChucNangDTO;
import Util.JDBCUtil;


public class ChucNangDAO {
	public static ChucNangDAO getIntance() {
		return new ChucNangDAO();
	}
	public ArrayList<ChucNangDTO> selectAll() {
		ArrayList<ChucNangDTO> ketQua=new ArrayList<ChucNangDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM chucnang";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String machucnang=rs.getString("machucnang");
				String tenchucnang=rs.getString("tenchucnang");
				ChucNangDTO q= new ChucNangDTO(machucnang, tenchucnang);
				ketQua.add(q);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	
	public int InsertChucNang(ChucNangDTO q) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO chucnang (machucnang, tenchucnang) VALUES ('"
		            + q.getMachucnang().toLowerCase() + "' , '" + q.getTenchucnang() + "')";
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
	public int upDateChucNang(ChucNangDTO q) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE chucnang SET machucnang='" + q.getMachucnang() + "',tenchucnang='"
					+ q.getTenchucnang() + "';";
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
	
	
	public int deleteChucNang(ChucNangDTO q) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM chucnang WHERE chucnang = '" + q.getMachucnang() + "'";
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
