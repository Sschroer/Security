package Security;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a basic login protocol which manages basic login information.
 * 
 * @author Stephen Schroer
 *
 */
public class UserLogin {
	private static Map<String, String> loginInfo = new HashMap<>();

	/**
	 * Prevents instantiation
	 */
	private UserLogin() {
	}

	/**
	 * Checks to see if username is already on map, if not it adds the login
	 * info.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean addUser(String username, String password) {
		if (loginInfo.containsKey(username)) {
			System.out.println("The username " + username + " already exists");
			return false;
		} else {
			System.out.println("User sucessfully added");
			loginInfo.put(username, password);
			return true;
		}
	}
	
	/**
	 * Checks to see if username and password are on the map.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {
	    if (loginInfo.containsKey(username)) {
	        if (loginInfo.get(username).equals(password)) {
	            System.out.println("Login Successful");
	            return true;
	        } else {
	            System.out.println("Login Failed: Incorrect password");
	            return false;
	        }
	    } else {
	        System.out.println("Login Failed: User not found");
	        return false;
	    }
	}
	
	public static boolean removeUser(String username) {
		if(loginInfo.containsKey(username)) {
			loginInfo.remove(username);
			System.out.println("User removed sucessfully");
			return true;
		}else {
			System.out.println("User not found");
			return false;
		}
	}
	
	
}

