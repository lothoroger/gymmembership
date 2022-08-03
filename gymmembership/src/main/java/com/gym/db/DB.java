package com.gym.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.gym.model.Batch;
import com.gym.model.Participant;

public class DB implements DAO {

	Connection conn;
	PreparedStatement pstm;
	final String TAG = "[" + getClass().getSimpleName() + "] ";

	public DB()  {
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Step 1: [DB] Driver Loaded");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}

	@Override
	public void createConnection() {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost/gymmembership";
			conn = DriverManager.getConnection(url, "admin", "root");
			System.out.println("Step 2: [DB] Connection Created");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[DB] Create Connection Exception Occured " + e);
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			conn.close();
			System.out.println("Step 4: "+TAG + "Connection Closed. Close Status: " + conn.isClosed());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "[DAO] Close Connection Exception Occured " + e);
		}

	}

	
	public int addBatch(Batch bt) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			
			String sql = "insert into Batch values(null, ?, ?, ?)";
			pstm =  conn.prepareStatement(sql);
			pstm.setString(1, bt.batchname);
			pstm.setString(2, bt.preferredTime);
			pstm.setString(3, bt.slot);
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "[DAO] create Batch Exception Occured " + e);
		}
		return result;
	}
	
	
	
	public void updateBatch(int id, Batch bt) {
		// TODO Auto-generated method stub
		int results=0;
		try {
		
			String sql = "update Batch set batchname='"+bt.batchname+"', preferredTime='"+bt.preferredTime+"', slot='"+bt.slot+"' where bid="+id;
			pstm = conn.prepareStatement(sql);
			
			int results1 = pstm.executeUpdate(sql);
			System.out.println("Step 3: [DB] Update Batch executed");
			String message = results1 > 0 ? "Updated Batch Successfuly"
					: "Batch not Updated. Please try again";
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "Update Batch Exception Occured " + e);
		}
		
	}
	
	
	public int deleteBatch(int bt) {
		// TODO Auto-generated method stub
	
		try {
			
			String sql = "delete from Batch where bid = ?";
			pstm =  conn.prepareStatement(sql);
			pstm.setInt(1, bt );
			int result = pstm.executeUpdate();
			String message = result > 0 ? "[Step 3: [DB] Delete Batch Successful"
					: "Batch  not Deleted. Please try again";
			System.out.println(message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "[DB] Delete Batch Error Exception Occured " + e);
		}
		return bt;
	}
	
	
	


	public int addParticipant(Participant pt) {
		// TODO Auto-generated method stub
		int resultp = 0;
		try {
			
			String sql = "insert into Participant values(null, ?, ?, ?,?)";
			pstm =  conn.prepareStatement(sql);
			pstm.setString(1, pt.name);
			pstm.setString(2, pt.phone);
			pstm.setString(3, pt.email);
			pstm.setInt(4, pt.bId);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "[DAO] create Batch Exception Occured " + e);
		}
		return resultp;
	}
	
	
	public int deleteParticipant(int pt) {
		// TODO Auto-generated method stub
	
		try {
			
			String sql = "delete from Participant where pid = ?";
			pstm =  conn.prepareStatement(sql);
			pstm.setInt(1, pt );
			int result = pstm.executeUpdate();
			String message = result > 0 ? "[Step 3: [DB] Delete Participant Successful"
					: "Participant  not Deleted. Please try again";
			System.out.println(message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "[DB] Delete Particpant Error Exception Occured " + e);
		}
		return pt;
	}
	
	

	public void updateParticipant(int id, Participant pt) {
		// TODO Auto-generated method stub
		int results=0;
		try {
		
			String sql = "update Participant set name='"+pt.name+"', phone='"+pt.phone+"', email='"+pt.email+"', bId="+pt.bId+" where pid="+id;
			pstm = conn.prepareStatement(sql);
			
			int results1 = pstm.executeUpdate(sql);
			System.out.println("Step 3: [DB] Update Particpant executed");
			String message = results1 > 0 ? "Updated Participant Successfuly"
					: "Participant not Updated. Please try again";
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(TAG + "Update Participant Exception Occured " + e);
		}
		
	}

	@Override
	public ArrayList<Batch> getBatch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Participant> getParticipant() {
		// TODO Auto-generated method stub
		
		ArrayList<Participant> party = new ArrayList<Participant>();
		try {
			String sql = "select * from Participant";
			pstm =  conn.prepareStatement(sql);
			
			ResultSet set = pstm.executeQuery();
			
			while(set.next()) {
				
				Participant pt = new Participant();
					pt.pId = set.getInt(1);
					pt.name = set.getString(2);
					pt.phone = set.getString(3);
					pt.email = set.getString(4);
					pt.bId = set.getInt(5);
					
					party.add(pt);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[DB] Participant Lists error "+e);
		}
		return party;
	}


	
}
