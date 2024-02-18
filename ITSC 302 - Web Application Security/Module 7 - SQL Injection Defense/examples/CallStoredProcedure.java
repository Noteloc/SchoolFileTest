import java.sql.*;

public class CallStoredProcedure
{
	public static void main(String args[])
	{
		String username="adam";
		//String username="' or 1=1); #";
		//String username="'); insert into users set username='zzz', password='zzz'; #";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/secureusers?allowMultiQueries=true","root","");
			
			String sql = "call getUser('" + username + "');";
			
			System.out.println("SQL STRING: " + sql);
			
			CallableStatement cs = conn.prepareCall(sql);
			
			ResultSet rs = cs.executeQuery(sql);
			
			while (rs.next())
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			
			rs.close();
			cs.close();
			conn.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}