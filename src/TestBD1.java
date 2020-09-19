import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestBD1 {

	public static void main(String[] args) {
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e)
		{
			System.err.println(e);
			System.exit(-1);
		}
		try {
			String url="jdbc:postgresql://localhost:5432/Exercice1";
			String user="postgres";
			String pwd="admin";
			Connection con=DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String req="INSERT INTO public.\"Article\"(\r\n" + 
					"	num, designation, qte)\r\n" + 
					"	VALUES (7, 'peripherique', 100);";
			s.executeUpdate(req);
			con.commit();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}
