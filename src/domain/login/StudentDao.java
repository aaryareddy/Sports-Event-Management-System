package domain.login;
/**
 * 
 * @author mehra
 * The methods that we need to save and retrieve data from the database
 */
public interface StudentDao {

	/*
	 * Retrieve the Customer object from the database
	 */
	public Student validateStudent(Login login);

	
	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object

	public int register(Student c);
}

