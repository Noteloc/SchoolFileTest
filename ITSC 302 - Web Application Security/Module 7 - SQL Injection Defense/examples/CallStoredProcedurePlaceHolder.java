import java.sql.*;

public class CallStoredProcedurePlaceHolder
{
	public static void main(String args[])
	{
		String username="adam";
		//String username="'); insert into users set username='zzz', password='zzz'; #";
		//String username="' or 1=1); #";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
			
			String sql = "call getUser(?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, username);
			
			ResultSet rs = cs.executeQuery();
			
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