package Question6;

import java.util.List;

/**
 * API for searching customer. 
 * A deliberate decision was made to elaborate the search functions. 
 * For clarity sake, we include the name of the field in the method signature. 
 * 
 * Features include:
 * 1. Provides searches by various available fields.
 * 2. Option to sort by a different column. 
 * 		If sortColumn is null or provided with incorrect value, the default sorting order is returned.
 * 		The default sorting order is he search result will be sorted by the order coming back from database.
 * 		Sort shall happen at the database layer using 'order by' clause.
 * 3. Option to specify a limit to the number of records returned. 
 * 		If limit is not specified, the default number of 25 is used.
 * 4. Option to specify an offset of the result pagination. Think of this as a page number in the case of multi-pages result set.
 * 		If offset is not specified, the default value of 1 is used.
 * 
 */
public interface SearchCustomer {
	
	/**
	 * Returns a list of customer searched by first name.
	 * 
	 * @param firstName search term.
	 * @param sortColumn optional string for column sorting
	 * @param limit optional integer to limit the number of search result
	 * @param offset optional integer to specify pagination
	 * @return
	 */
	public List<Customer> searchByFirstName(String firstName, String sortColumn, int limit, int offset);
	
	/**
	 * Returns a list of customer searched by last name.
	 * 
	 * @param firstName search term.
	 * @param sortColumn optional string for column sorting
	 * @param limit optional integer to limit the number of search result
	 * @param offset optional integer to specify pagination
	 * @return
	 */
	public List<Customer> searchByLastName(String lastName, String sortColumn, int limit, int offset);
	
	/**
	 * Returns a list of customer searched by street address.
	 * 
	 * @param firstName search term.
	 * @param sortColumn optional string for column sorting
	 * @param limit optional integer to limit the number of search result
	 * @param offset optional integer to specify pagination
	 * @return
	 */
	public List<Customer> searchByStreetAddress(String streetAddress, String sortColumn, int limit, int offset);
	
	/**
	 * Returns a list of customer searched by state.
	 * 
	 * @param firstName search term.
	 * @param sortColumn optional string for column sorting
	 * @param limit optional integer to limit the number of search result
	 * @param offset optional integer to specify pagination
	 * @return
	 */
	public List<Customer> searchByState(String state, String sortColumn, int limit, int offset);
}
