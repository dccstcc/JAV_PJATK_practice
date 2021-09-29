package permissions.db;

import java.util.List;

import permissions.domain.Address;

public interface AddressRepository extends Repository<Address> {
	public List<Address> withCountry(String country, PagingInfo page);
	public List<Address> withCity(String city, PagingInfo page);
	public List<Address> withStreet(String street, PagingInfo page);
	public List<Address> withPostalCode(String postalCode, PagingInfo page);
	public List<Address> withHouseNumber(String houseNumber, PagingInfo page);
	public List<Address> withLocalNumber(String LocalNumber, PagingInfo page);
}
