package dao;

	import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.tosyodto ;

public class tosyodao{
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	
public static int deleteTosyo(int id) {
		
		String sql = "DELETE FROM tosyotouroku WHERE id = ?";
		int result = 0;
		
		try (
				Connection con =getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			pstmt.setInt(1, id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}


public static List<tosyodto> selectAlltosyo(){
String sql = "SELECT * FROM tosyotouroku";
			// 返却用変数
			List<tosyodto> result = new ArrayList<>();

			

			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try (ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						int id = rs.getInt("id");
						String bname = rs.getString("bname");
						String sname = rs.getString("sname");
						String kname = rs.getString("kname");
						int isname = rs.getInt("isname");

						tosyodto employee = new tosyodto(id, bname, sname, kname, isname);
						
						result.add(employee);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (URISyntaxException e) {
				e.printStackTrace();
			}
			

			// Listを返却する。0件の場合は空のListが返却される。
			return result;
}


	

			
			
	




		// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
		public static int registertosyokadaisample(tosyodto tosyokadaisample) {
			
			String sql = "INSERT INTO tosyokadaisample VALUES(?, ?, ?, ?, ?)";

			// return用の変数
			int result = 0;
			
			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){
				pstmt.setInt(1, tosyokadaisample.getId());
				pstmt.setString(2, tosyokadaisample.getBname());
				pstmt.setString(3, tosyokadaisample.getSname());
				pstmt.setString(4, tosyokadaisample.getKname());
				pstmt.setInt(5, tosyokadaisample.getIsname());

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
			return result;
		}

}