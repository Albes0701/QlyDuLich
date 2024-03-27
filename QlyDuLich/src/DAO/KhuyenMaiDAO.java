package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KhuyenMaiDTO;
import DTO.NhanVienDTO;
import Util.JDBCUtil;


public class KhuyenMaiDAO {
	public static KhuyenMaiDAO getIntance() {
		return new KhuyenMaiDAO();
	}
	public ArrayList<KhuyenMaiDTO> selectAll() {
		ArrayList<KhuyenMaiDTO> ketQua=new ArrayList<KhuyenMaiDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM khuyenmai";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makm=rs.getString("makm");
				String tenctkm=rs.getString("tenctkm");
				double phantram=rs.getDouble("phantram");
				String doituong=rs.getString("doituong");
				String dieukien=rs.getString("dieukien");
				Date ngaybd=rs.getDate("ngaybatdau");
				Date ngaykt=rs.getDate("ngayketthuc");
				Boolean tinhtrang = rs.getBoolean("tinhtrang");
				KhuyenMaiDTO km = new KhuyenMaiDTO(makm, tenctkm, doituong, dieukien, phantram, ngaybd, ngaykt,tinhtrang);
				ketQua.add(km);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
		return ketQua;
	}
	

	public int InsertKhuyenMai(KhuyenMaiDTO t) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO khuyenmai (makm, tenctkm, doituong, dieukien, phantram, ngaybatdau, ngayketthuc,tinhtrang) VALUES ('"
		            + t.getMakm() + "' , '" + t.getTectkm() + "' , '" + t.getDoituong() + "' , '" + t.getDieukien() + "' , "
		            + t.getPhantram() + ", '" + t.getNgaybd() + "' , '" + t.getNgaykt() + "' , " + t.getTinhtrang() +")";
			System.out.println(sql);
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
	
	public int upDateKhuyenMai(KhuyenMaiDTO t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE khuyenmai SET makm='" + t.getMakm() + "',tenctkm='"
					+ t.getTectkm() + "',phantram=" + t.getPhantram() + ",doituong='" + t.getDoituong() + "',dieukien='"
					+ t.getDieukien() + "',ngaybatdau='" + t.getNgaybd() +  "',ngayketthuc='" + t.getNgaykt() +
					"',tinhtrang = " + t.getTinhtrang() + " WHERE makm='" + t.getMakm() + "';";
//			System.out.println(sql);
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
	
	public int deleteKhuyenMai(KhuyenMaiDTO t) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM khuyenmai WHERE makm = '" + t.getMakm() + "'";
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
	