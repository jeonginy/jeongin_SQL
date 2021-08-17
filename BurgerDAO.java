import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
	//	DAO = Data Access Object 
public class BurgerDAO {
	// 버거 추가
	public int add(Burger burger) {							//	원하는 값을 읽어오기 위해서 ? 설정
		String query = "INSERT INTO hamburger (brand, name, price) VALUES ( ?, ?, ?)";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, burger.getBrand());
			stmt.setString(2, burger.getName());
			stmt.setInt(3, burger.getPrice());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 버거 전체 조회
	public List<Burger> selectAll(){
		String query = "SELECT * FROM hamburger";
		// 들어가 있는 정보를 뽑아서 저장해둘 공간이 필요함 
		// table 형태로 뽑아내기 위해서는 List를 사용할 수 있음 (배열은 한 줄 저장이라서 X)
		List<Burger> list = new ArrayList<>();
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();){
			
			while( rs.next() ) {
				Burger burger = new Burger();
				
				burger.setId(rs.getInt("id"));
				burger.setBrand(rs.getString("brand"));
				burger.setName(rs.getString("name"));
				burger.setPrice(rs.getInt("price"));
				
				list.add(burger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 버거의 가격 범위로 조회	: 범위를 가져와야 하기 때문에 parameter 사용
	public List<Burger> selectBtPriceRange(int p, int p2){
		List<Burger> list = new ArrayList<>();
		String query = "SELECT * FROM hamburger" + "WHERE price BETWEEN  ? AND ?";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();){
			
			while( rs.next() ) {
				Burger burger = new Burger();
				
				burger.setId(rs.getInt("id"));
				burger.setBrand(rs.getString("brand"));
				burger.setName(rs.getString("name"));
				burger.setPrice(rs.getInt("price"));
				
				list.add(burger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 브랜드별 평균가 : 새로운 브랜드의 햄버거 가격이 들어오게 될 때를 위해 Map 사용
	public Map<String, Integer> selectAvgPriceByBrand(){
		Map<String, Integer> map = new LinkedHashMap<>();
		String query = "SELECT brand, AVG(price) AS avg FROM hamburger GROUP BY brand";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);	
				ResultSet rs = stmt.executeQuery();) {	//	결과를 담고 있음 
			while(rs.next()) {
				String brand = rs.getString("brand");
				int avg = rs.getInt("avg");

				map.put(brand, avg);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 버거 수정
	public int update(Burger burger) {
		String query = "UPDATE hamburger SET brand = ?, name =?, price =? WHERE id=?";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {

			Burger bruger = new Burger();
			stmt.setString(1,  burger.getBrand()); 
			stmt.setString(2,  burger.getName());
			stmt.setInt(3,  burger.getPrice());
			stmt.setInt(4,  burger.getId());
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	

	// 버거 삭제
	public int delete(int id) {
		String query = "DELETE FROM hamburger WHERE id = ?";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setInt(1, id);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
	
	}
		
}












