package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import Util.JDBCUtil;

public class KhachHangDAO {
	public static KhachHangDAO getIntance() {
		return new KhachHangDAO();
	}
	
	public ArrayList<KhachHangDTO> selectAll(){
		ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
		try {
			//Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//Tạo đối tượng
			java.sql.Statement st = con.createStatement();
			//SQL
			String sql = "SELECT * FROM khachhang ";
			System.out.println(sql);
			ResultSet rs= st.executeQuery(sql);
			//Xu ly ket qua roi tra ve
			while(rs.next()) {
				String makh = rs.getString("makh");
				String hokh = rs.getString("hokh");
				String tenkh = rs.getString("tenkh");
				Boolean gioitinh = rs.getBoolean("gioitinh");
				String dotuoi = rs.getString("dotuoi");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				Float tongchi = rs.getFloat("tongchi");
                KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, dotuoi, diachi, sdt, email, gioitinh, tongchi);
                result.add(kh);


			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public KhachHangDAO() {
		// TODO Auto-generated constructor stub
	}
	public int deleteKhachHang(KhachHangDTO k) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "DELETE FROM khachhang WHERE makh = '" + k.getMakh() + "'";
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
	
	
	public int upDateKhachHang(KhachHangDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "UPDATE khachhang SET hokh='" + t.getHokh() + "',tenkh='"
					+ t.getTenkh() + "',gioitinh=" + t.isGioitinh() + ",dotuoi='" + t.getDotuoi() + "',diachi='"
					+ t.getDiachi() + "',sdt='" + t.getSdt() +  "',email='" + t.getEmail() +
					"' WHERE makh='" + t.getMakh() + "';";
			System.out.println(sql);
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

}
