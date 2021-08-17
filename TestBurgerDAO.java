public class TestBurgerDAO {
	private static BurgerDAO dao = new BurgerDAO();
	
	private static void testAdd() {
		Burger burger = new Burger();
		
		burger.setBrand("맘스터치");
		burger.setName("치즈홀릭버거");
		burger.setPrice(5100);
		
		int result = dao.add(burger);
		System.out.println(result + "행 추가됨");
		
	}
	
//	private static void testDelete(int id) {
//		int result = dao.result;
//		
//		
//	}
	
	public static void main(String[] args) {
		BurgerDAO doa = new BurgerDAO();
		Burger burger = new Burger();
		
		burger.setBrand("맘스터치");
		burger.setName("치츠홀릭버거");
		burger.setPrice(5100);
		
		int result = doa.add(burger);
		System.out.println(result + "행 추가됨");

	}

}
