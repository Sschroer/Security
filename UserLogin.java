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
	        // Check if password is null or empty
	        if (password == null || password.isEmpty()) {
	            System.out.println("Password cannot be null or empty");
	            return false;
	        }
	        System.out.println("User successfully added");
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
	/**
	 * Removes username and password from the user list.
	 * @param username
	 * @return
	 */
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
	
	/**
	 * Resets pasword is user exists.
	 * @param username
	 * @param oldPass
	 * @param newPass
	 * @return
	 */
	public static boolean editPassword(String username, String oldPass, String newPass) {
	    if (!loginInfo.containsKey(username)) {
	        System.out.println("User not found");
	        return false;
	    }

	    if (loginInfo.get(username).equals(oldPass)) {
	        loginInfo.put(username, newPass);
	        System.out.println("Password successfully reset");
	        return true;
	    }

	    // If old password doesn't match
	    System.out.println("Incorrect old password");
	    return false;
	}
}

