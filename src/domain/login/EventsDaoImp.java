package domain.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;

public class EventsDaoImp implements EventDao{

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	EventsDaoImp(){
		//conn = db.getConnection();
	}
	
	@Override
	public List<Event> getCurrentEvents() {
		// TODO Auto-generated method stub
		List<Event> listCurrentEvents = new ArrayList<>();
		
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from Events");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Event event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8));
				listCurrentEvents.add(event);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return listCurrentEvents;
	}

	@Override
	public int addEvent(Event event) {
	    	int status = 0;
	    	
			try{
				conn = db.getConnection();
				String query = "SELECT MAX(EventId) AS `maxid` FROM events";
				Statement st = conn.createStatement(); 
			    ResultSet rs = st.executeQuery(query);
			    int maxid=0;
			    while (rs.next())
			      {
			        maxid = rs.getInt("maxid");
			      }
			    
				ps =conn.prepareStatement("insert into events values(?,?,?,?,?,?,?,?)");
		//		ps =conn.prepareStatement("INSERT INTO events (title, desc, id) VALUES (?, ?, ?)");
				ps.setInt(1, maxid+1);
				ps.setString(2, event.getTopic());
				ps.setString(3, event.getEventType());
				
				ps.setDate(4, event.getEventDate());
				ps.setString(5, event.getLocation());
				ps.setFloat(6, event.getPrice());
				ps.setString(7, event.getEventTime());
				ps.setString(8, event.getDescription());
								
				
				status = ps.executeUpdate();
				conn.close();
			}catch(Exception e){
				System.out.println(e);
			}
		
			return status;
	    	
	    }

	@Override
	public Event getRequiredEvent(String eventTopic) {
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from Events where Topic = ?");
			ps.setString(1, eventTopic);
			ResultSet rs = ps.executeQuery();
			Event event = null;
			while(rs.next()){
				event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8));
			}
			return event;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public Event getEvent(String id) {
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from Events where EventId = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Event event = null;
			while(rs.next()){
				event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8));
			}
			
			return event;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public int updateEvent(Event event) {
	    	int status = 0;
	    	
			try{
				conn = db.getConnection();
			//	String query = "SELECT MAX(EventId) AS `maxid` FROM events";
			//	Statement st = conn.createStatement(); 
			 //   ResultSet rs = st.executeQuery(query);
			//    int maxid=0;
			//    while (rs.next())
			//      {
			//        maxid = rs.getInt("maxid");
			//      }
			    
				ps =conn.prepareStatement("update events SET EventId = ? , Topic = ?, EventType = ? , EventDate = ?, Location= ?, Price = ?, EventTime = ?, Description = ? WHERE EventId = ?");
		//		ps =conn.prepareStatement("INSERT INTO events (title, desc, id) VALUES (?, ?, ?)");
				ps.setInt(1, event.getEventId());
				ps.setString(2, event.getTopic());
				ps.setString(3, event.getEventType());
				
				ps.setDate(4, event.getEventDate());
				ps.setString(5, event.getLocation());
				ps.setFloat(6, event.getPrice());
				ps.setString(7, event.getEventTime());
				ps.setString(8, event.getDescription());
				ps.setInt(9, event.getEventId());
								
				
				status = ps.executeUpdate();
				conn.close();
			}catch(Exception e){
				System.out.println(e);
			}
		
			return status;
	    	
	    }
	
	
	@Override
	public int cancelEvent(String id) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("delete from Events where EventId = ?");
			ps.setString(1, id);
			status = ps.executeUpdate();
			
			conn.close();
			return status;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
		
		
	}
	
	}


