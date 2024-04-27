package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhanVienDTO;
import DTO.taikhoanDTO;
import Util.JDBCUtil;

public class taikhoanDAO {
	public static taikhoanDAO getIntance() {
		return new taikhoanDAO();
	}
	
	public ArrayList<taikhoanDTO> selectAll() {
		ArrayList<taikhoanDTO> ketQua=new ArrayList<taikhoanDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM taikhoan";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String user=rs.getString("user_name");
				String passs=rs.getString("PassWord");
				taikhoanDTO tk = new taikhoanDTO(user, passs);
				ketQua.add(tk);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public String getInfo(String user_name) {
		String user="";
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT honv,tennv FROM nhanvien nv INNER JOIN taikhoan tk ON nv.manv = '" + user_name + "'";
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next())
				user=rs.getString("honv")+ " " +rs.getString("tennv");
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return user;
	}
}
