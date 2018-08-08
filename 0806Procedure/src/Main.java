import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {

	public static void main(String[] args) {
		Connection con= null;
		CallableStatement  call = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			//���ν����� ������ ����
			/*call = con.prepareCall("{call insertdept(?,?,?)}");
			call.setInt(1, 50);
			call.setString(2, "����");
			call.setString(3, "����");*/
			
			//���ν����� ������ ����
			call = con.prepareCall("{call deletedept(?)}");
			call.setInt(1, 50);
			
			int r = call.executeUpdate();
			
			if(r > 0) System.out.println("��������");
			else System.out.println("��������");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if( call != null) call.close();
				if( con != null) con.close();
			} catch (Exception e) {}
		}
		

	}

}
