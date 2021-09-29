package permissions.db.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import permissions.db.PagingInfo;
import permissions.db.AddressRepository;
import permissions.domain.Address;

public class HsqlAddressRepository implements AddressRepository{

	private Connection connection;
	
	private String insertSql ="INSERT INTO address(country,city,street,postalCode,houseNumber,localNumber) VALUES(?,?,?,?,?,?)"; 
	private String selectSql ="SELECT * FROM address LIMIT(?,?,?,?,?,?)";
	private String selectByIdSql ="SELECT * FROM address WHERE id=?";
	private String selectByCountrySql ="SELECT * FROM address WHERE Country=? LIMIT(?,?,?,?,?,?)";
	private String selectByCitySql ="SELECT * FROM address WHERE City=? LIMIT(?,?,?,?,?,?)";
	private String selectByStreetSql ="SELECT * FROM address WHERE Street=? LIMIT(?,?,?,?,?,?)";
	private String selectByPostalCodeSql ="SELECT * FROM address WHERE PostalCode=? LIMIT(?,?,?,?,?,?)";
	private String selectByHouseNumberSql ="SELECT * FROM address WHERE HouseNumber=? LIMIT(?,?,?,?,?,?)";
	private String selectByLocalNumberSql ="SELECT * FROM address WHERE LocalNumber=? LIMIT(?,?,?,?,?,?)";
	private String deleteSql = "DELETE FROM address WHERE id=?";
	private String updateSql = "UPDATE address SET (country,city,street,postalCode,houseNumber,localNumber)=(?,?,?,?,?,?) WHERE id=?";
	
	private PreparedStatement insert;
	private PreparedStatement select;
	private PreparedStatement selectById;
	private PreparedStatement selectByCountry;
	private PreparedStatement selectByCity;
	private PreparedStatement selectByStreet;
	private PreparedStatement selectByPostalCode;
	private PreparedStatement selectByHouseNumber;
	private PreparedStatement selectByLocalNumber;
	private PreparedStatement delete;
	private PreparedStatement update;
	

	private String createAddressTable =""
			+ "CREATE TABLE Address("
			+ "country VARCHAR(30),"
			+ "city VARCHAR(30),"
			+ "street VARCHAR(30),"
			+ "postalCode VARCHAR(10),"
			+ "houseNumber VARCHAR(10),"
			+ "localNumber VARCHAR(10),"
			+ ")";
	
	
	public HsqlAddressRepository(Connection connection){
		this.connection=connection;
		
		try{
			

			insert = connection.prepareStatement(insertSql);
			select = connection.prepareStatement(selectSql);
			selectById = connection.prepareStatement(selectByIdSql);
			selectByCountry = connection.prepareStatement(selectByCountrySql);
			selectByCity = connection.prepareStatement(selectByCitySql);
			selectByStreet = connection.prepareStatement(selectByStreetSql);
			selectByPostalCode = connection.prepareStatement(selectByPostalCodeSql);
			selectByHouseNumber = connection.prepareStatement(selectByHouseNumberSql);
			selectByLocalNumber = connection.prepareStatement(selectByLocalNumberSql);
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
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	
	public Address withId(int id) {
		Address result = null;
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result = address;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Address> allOnPage(PagingInfo page) {
		List<Address> result = new ArrayList<Address>();
		
		try {
			select.setInt(1, page.getCurrentPage()*page.getSize());
			select.setInt(2, page.getSize());
			ResultSet rs = select.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void add(Address address) {
		try {
			insert.setString(1, address.getCountry());
			insert.setString(2, address.getCity());
			insert.setString(3, address.getStreet());
			insert.setString(4, address.getPostalCode());
			insert.setString(5, address.getHouseNumber());
			insert.setString(6, address.getLocalNumber());
			insert.setInt(7, address.getId());
			
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void modify(Address a) {
		try {
			update.setString(1, a.getCountry());
			update.setString(2, a.getCity());
			update.setString(3, a.getStreet());
			update.setString(4, a.getPostalCode());
			update.setString(5, a.getHouseNumber());
			update.setString(6, a.getLocalNumber());
			update.setInt(7, a.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void remove(Address a) {
		try {
			delete.setInt(1, a.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Address> withCity(String city, PagingInfo page) {
		
		List<Address> result = new ArrayList<Address>();
		try {
			selectByCity.setString(1, city);
			selectByCity.setInt(2, page.getCurrentPage()*page.getSize());
			selectByCity.setInt(3, page.getSize());
			ResultSet rs = selectByCity.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Address> withCountry(String country, PagingInfo page) {
		
		List<Address> result = new ArrayList<Address>();
		try {
			selectByCountry.setString(1, country);
			selectByCountry.setInt(2, page.getCurrentPage()*page.getSize());
			selectByCountry.setInt(3, page.getSize());
			ResultSet rs = selectByCountry.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Address> withStreet(String street, PagingInfo page) {
	
	List<Address> result = new ArrayList<Address>();
	try {
		selectByStreet.setString(1, street);
		selectByStreet.setInt(2, page.getCurrentPage()*page.getSize());
		selectByStreet.setInt(3, page.getSize());
		ResultSet rs = selectByStreet.executeQuery();
		while(rs.next()){
			Address address = new Address();
			address.setCountry(rs.getString("country"));
			address.setCity(rs.getString("city"));
			address.setStreet(rs.getString("street"));
			address.setPostalCode(rs.getString("postalCode"));
			address.setHouseNumber(rs.getString("houseNumber"));
			address.setLocalNumber(rs.getString("localNumber"));
			address.setId(rs.getInt("id"));
			result.add(address);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
	}
	
	public List<Address> withPostalCode(String postalCode, PagingInfo page) {
		
		List<Address> result = new ArrayList<Address>();
		try {
			selectByPostalCode.setString(1, postalCode);
			selectByPostalCode.setInt(2, page.getCurrentPage()*page.getSize());
			selectByPostalCode.setInt(3, page.getSize());
			ResultSet rs = selectByPostalCode.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
public List<Address> withHouseNumber(String houseNumber, PagingInfo page) {
		
		List<Address> result = new ArrayList<Address>();
		try {
			selectByHouseNumber.setString(1, houseNumber);
			selectByHouseNumber.setInt(2, page.getCurrentPage()*page.getSize());
			selectByHouseNumber.setInt(3, page.getSize());
			ResultSet rs = selectByHouseNumber.executeQuery();
			while(rs.next()){
				Address address = new Address();
				address.setCountry(rs.getString("country"));
				address.setCity(rs.getString("city"));
				address.setStreet(rs.getString("street"));
				address.setPostalCode(rs.getString("postalCode"));
				address.setHouseNumber(rs.getString("houseNumber"));
				address.setLocalNumber(rs.getString("localNumber"));
				address.setId(rs.getInt("id"));
				result.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Address> withLocalNumber(String localNumber, PagingInfo page) {
	
	List<Address> result = new ArrayList<Address>();
	try {
		selectByLocalNumber.setString(1, localNumber);
		selectByLocalNumber.setInt(2, page.getCurrentPage()*page.getSize());
		selectByLocalNumber.setInt(3, page.getSize());
		ResultSet rs = selectByLocalNumber.executeQuery();
		while(rs.next()){
			Address address = new Address();
			address.setCountry(rs.getString("country"));
			address.setCity(rs.getString("city"));
			address.setStreet(rs.getString("street"));
			address.setPostalCode(rs.getString("postalCode"));
			address.setHouseNumber(rs.getString("houseNumber"));
			address.setLocalNumber(rs.getString("localNumber"));
			address.setId(rs.getInt("id"));
			result.add(address);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
	}

	

}
