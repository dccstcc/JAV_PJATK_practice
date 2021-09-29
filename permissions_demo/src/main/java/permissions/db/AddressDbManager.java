package permissions.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import permissions.domain.Address;

public class AddressDbManager {

	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createAddressTable =""
			+ "CREATE TABLE Address("
			+ "country VARCHAR(30),"
			+ "city VARCHAR(30),"
			+ "street VARCHAR(30),"
			+ "postalCode VARCHAR(10),"
			+ "houseNumber VARCHAR(10),"
			+ "localNumber VARCHAR(10),"
			+ ")";
	
	private String insertSql ="INSERT INTO address(country,city,street,postalCode,houseNumber,localNumber) VALUES(?,?,?,?,?,?)"; 
	private String selectSql ="SELECT * FROM address";
	private String deleteSql = "DELETE FROM address WHERE id=?";
	private String updateSql = "UPDATE address SET (country,city,street,postalCode,houseNumber,localNumber)=(?,?,?,?,?,?) WHERE id=?";
	
	private PreparedStatement insert;
	private PreparedStatement select;
	private PreparedStatement delete;
	private PreparedStatement update;
	
	public AddressDbManager(){
		
		try {
			connection = DriverManager.getConnection(url);
			
			insert = connection.prepareStatement(insertSql);
			select = connection.prepareStatement(selectSql);
			delete = connection.prepareStatement(deleteSql);
			update = connection.prepareStatement(updateSql);
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean tableExists =false;
			while(rs.next())
			{
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("Address")){
					tableExists=true;
					break;
				}
			}
			
			if(!tableExists){
				Statement createTable = connection.createStatement();
				createTable.executeUpdate(createAddressTable);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void add(Address address){
		
		try {
			insert.setString(1, address.getCountry());
			insert.setString(2, address.getCity());
			insert.setString(3, address.getStreet());
			insert.setString(4, address.getPostalCode());
			insert.setString(5, address.getHouseNumber());
			insert.setString(6, address.getLocalNumber());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteById(int id){
		
		try {
			delete.setInt(1, id);
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Address a){
		
		try {
			update.setString(1, a.getCountry());
			update.setString(2, a.getCity());
			update.setString(3, a.getStreet());
			update.setString(4, a.getPostalCode());
			update.setString(5, a.getHouseNumber());
			update.setString(6, a.getLocalNumber());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<Address> getAll(){
		
		List<Address> result = new ArrayList<Address>();
		
		try {
			ResultSet rs = select.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}



























