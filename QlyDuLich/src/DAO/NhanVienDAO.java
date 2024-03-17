package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVienDTO;
import Util.JDBCUtil;


public class NhanVienDAO {
	public static NhanVienDAO getIntance() {
		return new NhanVienDAO();
	}
	public ArrayList<NhanVienDTO> selectAll() {
		ArrayList<NhanVienDTO> ketQua=new ArrayList<NhanVienDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM nhanvien";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String manv=rs.getString("manv");
				String honv=rs.getString("honv");
				String tennv=rs.getString("tennv");
				String sdt=rs.getString("sdt");
				Boolean gioitinh=rs.getBoolean("gioitinh");
				String cmnd=rs.getString("cmnd");
				Date ngayvl=rs.getDate("ngayvl");
				NhanVienDTO nv= new NhanVienDTO(manv, honv, tennv, sdt, cmnd, cmnd, ngayvl, gioitinh);
				ketQua.add(nv);
				
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
}
