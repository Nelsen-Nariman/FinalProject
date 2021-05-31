package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import Db.ConnectDatabase;
import Model.Menu;

public class MenuDAO {
	
	Random random = new Random();
	
	private Connection connection;
	
	//DAO -> istilahnya Data Access Object -> gunanya utk perantara antara view/tampilan dengan database/connection.
	public MenuDAO() {
		
		connection = ConnectDatabase.connectDatabase();
		
	}
	
	public void insert(Menu menu) {
		//import dari java.sql
		try {
			Statement stmt = connection.createStatement(); //gunanya untuk mengeksekusi query
			
			//String query = "insert into pet values ('PE003','"+pet.getName()+"','"+pet.getGender()+"','"+pet.getTraits()+"',"+pet.getAge()+")";
			String query = String.format("insert into menu values ('%s', '%s', '%s','%s')", getLatestKode(), menu.getNama(), menu.getHarga(), menu.getStok());
			
			stmt.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		getLatestId();
	}
	
//	public void delete(Menu menu) {
//		try {
//			Statement stmt = connection.createStatement(); //gunanya untuk mengeksekusi query
//			
//			//String query = "insert into pet values ('PE003','"+pet.getName()+"','"+pet.getGender()+"','"+pet.getTraits()+"',"+pet.getAge()+")";
//			String query = String.format("insert into menu values ('%s', '%s', '%s','%s')", getLatestKode(), menu.getNama(), menu.getHarga(), menu.getStok());
//			
//			stmt.execute(query);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	private String getLatestKode() {
		
		String kode = "";
		
		try {
			Statement stmt = connection.createStatement();
			//asc
			String query = "select kode from menu order by kode desc limit 1";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				kode = rs.getString(1); //column ke 1
			}
			
//			if(kode.isEmpty()) {
//				kode = "BC001";
//			}
//			else {
//				kode = kode.replaceAll( "[^0-9]" , "");
				
				
//				int kodeInteger = (Integer.parseInt(kode) + 1);
				int kodeInteger=0;
				int kodeInteger2=0;
				int kodeInteger3=0;
				
//				for(int idx=0; idx<3; idx++) {
					kodeInteger+=random.nextInt(10);
					kodeInteger2+=random.nextInt(10);
					kodeInteger3+=random.nextInt(10);
//				}
				kode = "BC" + String.format("%d%d%d", kodeInteger, kodeInteger2, kodeInteger3);
				
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//    4 -> 004
		// 23 -> 023
		
		//System.out.println(id);
		
		return kode;
		
	}

	public Vector<Vector<String>> getMenus(){
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = "select * from menu";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				Vector<String> subData = new Vector<String>();
				
				subData.add(rs.getString(1));
				subData.add(rs.getString(2));
				subData.add(rs.getString(3));
				subData.add(rs.getString(4));
				
				data.add(subData);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void delete(String nama) {
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = "delete from menu where nama = '"+nama+"'";
			
					
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Menu menu) {
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = String.format("update menu set nama = '%s', harga = '%s', stok = '%s' where kode = '%s'", menu.getNama(),
					menu.getHarga(), menu.getStok(), menu.getKode());
			
			stmt.execute(query);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

