package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.CT_Quyen_ChucNang_DTO;
import Util.JDBCUtil;


public class CT_Quyen_ChucNang_DAO {
	public static CT_Quyen_ChucNang_DAO getIntance() {
		return new CT_Quyen_ChucNang_DAO();
	}
	public ArrayList<CT_Quyen_ChucNang_DTO> select(String mq) {
		ArrayList<CT_Quyen_ChucNang_DTO> ketQua=new ArrayList<CT_Quyen_ChucNang_DTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM ct_quyen_chucnang WHERE maquyen = '" + mq +"'";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String maquyen=rs.getString("maquyen");
				String machucnang=rs.getString("machucnang");
				CT_Quyen_ChucNang_DTO q= new CT_Quyen_ChucNang_DTO(maquyen, machucnang);
				ketQua.add(q);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	
	public int InsertQuyen_ChucNang(ArrayList<CT_Quyen_ChucNang_DTO> list) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO ct_quyen_chucnang (maquyen, machucnang)VALUES ";
			for(CT_Quyen_ChucNang_DTO t: list) {
				sql += "('" + t.getMaquyen().toLowerCase() + "' , '" + t.getMachucnang() + "'),";				
			}
			sql = sql.substring(0, sql.length()-1);
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
	
	public int deleteQuyen_ChucNang(String maquyen) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM ct_quyen_chucnang WHERE maquyen = '" + maquyen + "'";
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
	
	public ArrayList<String> selectChucNang(String maquyen){
		ArrayList<String> ketQua=new ArrayList<String>();

			try {
				//Bước 1:Tạo kết nối
				Connection con=JDBCUtil.getConnection();
				//Bước 2:Tạo đối tượng statement
				java.sql.Statement st=con.createStatement();
				//Bước 3:Thực thi statement
				String sql="SELECT ct.machucnang "
						+ "FROM taikhoan tk "
						+ "JOIN quyen q ON tk.quyen = q.maquyen "
						+ "JOIN ct_quyen_chucnang ct ON q.maquyen = ct.maquyen "
						+ "WHERE ct.maquyen = '" + maquyen + "'";
				System.out.println(sql);
				ResultSet rs=st.executeQuery(sql);
				//Bước 4:Xử lý kết quả trả về
				while(rs.next()){
					String machucnang = rs.getString("machucnang");
					ketQua.add(machucnang);
				}
				//Bước 5:Ngắt kết nối
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	
			return ketQua;
		}
	}
