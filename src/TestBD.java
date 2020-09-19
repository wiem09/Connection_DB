import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestBD {

	public static void main(String[] args) {
		try{ Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException e) {
			System.err.println(e);
			System.exit(-1);
		}
		try{
			String url="jdbc:postgresql://localhost:5432/Exercice1";
			String user="postgres";
			String pwd="admin";
			Connection conn=DriverManager.getConnection(url, user, pwd);
			Statement s=conn.createStatement();
			String req="select * from \"Article\"";
			ResultSet res=s.executeQuery(req);
			ResultSetMetaData rm=res.getMetaData();
			Integer taille=rm.getColumnCount();
			for(int i=1;i<taille+1;i++)
				System.out.print(rm.getColumnName(i)+"\t\t");
			    System.out.println("\n");
			    while(res.next())
			    {
			    	for(int i=1;i<taille+1;i++)
			    		System.out.print(res.getObject(i).toString()+"\t");
			    	    System.out.println("\n");
			    }
				
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}