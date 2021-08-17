import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		// auto라서 try문 ()안 에 넣어줘야 함, 
		try (Connection conn = ConnectionProvider.getConnection();
				// 실행할 제어문을 넣어두기 
				PreparedStatement stmt = conn.prepareStatement("SELECT 1");	//	 connection이 잘 되면 1
				// 결과 값을 수행하기 
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				// 값 하나를 읽고, 뽑아내기
				// if( rs != null ) { 도 가능 
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
