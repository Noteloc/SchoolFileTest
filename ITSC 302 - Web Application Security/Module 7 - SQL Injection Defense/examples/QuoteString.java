import java.sql.*;

public class QuoteString
{
	public static void main(String args[])
	{
		String username="adam";
		//String password="adam";
		String password= "' or 1=1; #"; 
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
			
			//REPLACE QUOTES...
			password = password.replaceAll("'", "\"");
			
			String sql = "select * from users where username='" + username + "' and password='" + password + "';";
			
			System.out.println("SQL STRING: " + sql);
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			
			rs.close();
			st.close();
			conn.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}