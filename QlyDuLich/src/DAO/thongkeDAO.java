package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.thongkeDTO;
import Util.JDBCUtil;

public class thongkeDAO {
	public static thongkeDAO getIntance() {
		return new thongkeDAO();
	}
	public int getLuotKhach(String year) {
		int quantity = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT COUNT(v.mave) as quatity FROM hoadon hd JOIN ve v ON hd.mahd = v.mahd WHERE YEAR(hd.ngaytao) = '" +year+ "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				quantity = rs.getInt("quatity");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
	
	public double getDoanhThu(String year) {
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT SUM(hd.tongtien) as total FROM hoadon hd WHERE YEAR(hd.ngaytao) = '" +year+ "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public ArrayList<HoaDonDTO> getTK_NV(String year) {
		ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT hd.manv , SUM(hd.tongtien) as total FROM hoadon hd WHERE YEAR(hd.ngaytao) = '" +year+ "' GROUP BY hd.manv ORDER BY total DESC";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
				String manv = rs.getString("manv");
				HoaDonDTO hd = new HoaDonDTO(null,manv , null, null, total,0);
				list.add(hd);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<thongkeDTO> getTk_tours_thu(String year){
		ArrayList<thongkeDTO> list = new ArrayList<>();
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT kht.makht,kht.matour, ((kht.soluong - kht.songuoi)*kht.giave*(100-km.phantram)/100) as thu"+
					" FROM kehoachtour kht" +
					" LEFT JOIN ve v ON kht.makht = v.makht" +
					" LEFT JOIN khuyenmai km ON v.makm = km.makm" + 
					" WHERE YEAR(kht.ngaydi) = '" +year+ "'" +
					" GROUP BY kht.makht,kht.matour";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht = rs.getString("makht");
				String matour = rs.getString("matour");
				double thu = rs.getDouble("thu");
				thongkeDTO tk = new thongkeDTO(makht, matour, 0, thu);
				list.add(tk);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<HoaDonDTO> getTK_KH(String year) {
		ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT hd.makh , SUM(hd.tongtien) as total FROM hoadon hd WHERE YEAR(hd.ngaytao) = '" +year+ "' GROUP BY hd.makh  ORDER BY total DESC";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
				String makh = rs.getString("makh");
				HoaDonDTO hd = new HoaDonDTO(null,null , makh, null, total,0);
				list.add(hd);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public double getTongChi(String year) {
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT SUM(kht.tongchi) as chi"
					+ " FROM kehoachtour kht"
					+ " WHERE YEAR(kht.ngaydi) = '"  +year+ "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("chi");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	 public double getQuy(int start, int end) {
		 double doanhthu = 0;
		 try {
				//Bước 1:Tạo kết nối
				Connection con=JDBCUtil.getConnection();
				//Bước 2:Tạo đối tượng statement
				java.sql.Statement st=con.createStatement();
				//Bước 3:Thực thi statement
				String sql="SELECT SUM(hd.tongtien) as thu FROM hoadon hd WHERE MONTH(hd.ngaytao) BETWEEN " + start +" AND "+ end;
				ResultSet rs=st.executeQuery(sql);
				//Bước 4:Xử lý kết quả trả về
				while(rs.next()){
					doanhthu = rs.getDouble("thu");
				}
				//Bước 5:Ngắt kết nối
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return doanhthu;
	 }
	 
	
}
