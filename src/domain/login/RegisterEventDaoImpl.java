package domain.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DbManager;



public class RegisterEventDaoImpl implements RegisterEventDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public int addEvent(RegisterEvent registerevent) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into reservation values(?,?,?,?,?)");
			ps.setString(1, registerevent.getUsername());
			ps.setString(2, registerevent.getPhoneNumber());
			ps.setString(3, registerevent.getEventName());
			ps.setString(4, registerevent.getCategory());
			ps.setString(5, registerevent.getAddress());
			
			status = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
}

