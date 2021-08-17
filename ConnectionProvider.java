import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//	connection만 해주는 클래스 
public class ConnectionProvider {
	// properties클래스를 가진 객체 : 설정값, 드라이브 이름, DB접속 주소, ID,PASSWORD 담음
	private static Properties props = new Properties();
	
	static {
		FileInputStream fis = null;
		try {
//			파일 객체 읽어서 넣기, 불러오기
			fis = new FileInputStream(".\\dbConn.properties");
			props.load(fis);
			
			Class.forName(props.getProperty("DRIVER_NAME"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	connection을 생성해서 반환하는 메소드 
	public static Connection getConnection() throws SQLException {
		// 필요한 URL,ID,PASSWORD 넣기
		return DriverManager.getConnection(props.getProperty("URL")
											, props.getProperty("ID")
											, props.getProperty("PASSWORD"));
	}
}









