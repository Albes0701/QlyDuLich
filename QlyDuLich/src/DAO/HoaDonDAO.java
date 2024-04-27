package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.VeDTO;
import Util.JDBCUtil;

public class HoaDonDAO {
	public static HoaDonDAO getIntance() {
		return new HoaDonDAO();
	}

	public ArrayList<HoaDonDTO> selectAll() {
		ArrayList<HoaDonDTO> ketqua = new ArrayList<HoaDonDTO>();
		try {
			Connection con = JDBCUtil.getConnection();
			java.sql.Statement st = con.createStatement();
			String sql = "select * from hoadon";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String mahd = rs.getString("mahd");
				String manv = rs.getString("manv");
				String makh = rs.getString("makh");
				Date ngaytao = rs.getDate("ngaytao");
				double tongtien = rs.getDouble("tongtien");
				HoaDonDTO hoadon=new HoaDonDTO(mahd, manv, makh, ngaytao, tongtien);
				ketqua.add(hoadon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int InsertHoaDon(HoaDonDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "INSERT INTO hoadon (mahd,manv,makh,ngaytao,tongtien)" + " VALUES('"
					+ t.getMahd() + "','" + t.getManv() + "','" + t.getMakh() + "','" + t.getNgaytao() + "',"
					+ t.getTongtien() + ")";
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	
	
	
	
}
