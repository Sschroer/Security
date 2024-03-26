package Security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserLoginTest {
	static String userOne = "";
	static String userOnePass = "";
	static String userTwo = "UserTwo";
	static String userTwoPass = "cBa54321!";
	static String userThree = "NonExistentUser";
	static Map<String,String> loginInfo = new HashMap<>();
	static UserLogin login = new UserLogin(loginInfo);

	@BeforeAll
	public static void setUp() {
		userOne = "UserOne";
	    userOnePass = "12345AbC";
		login.addUser(userOne, userOnePass);
		
	}

	@Test
	void addUserPass() {
		assertTrue(login.addUser(userTwo, userTwoPass));
	}

	@Test
	void addUserFail() {
		login.addUser(userOne, userOnePass);
		assertFalse(login.addUser(userOne, userOnePass));
	}


	@Test
	void addUserFailPassword() {
		assertFalse(login.addUser(userThree, ""));
	}

	@Test
	void loginTestPass() {
		assertTrue(login.login(userOne, userOnePass));
	}

	@Test
	void loginTestFailUserError() {
		assertFalse(login.login(userThree, userOnePass));
	}

	@Test
	void loginTestFailPasswordError() {
		assertFalse(login.login(userOne, userTwoPass));
	}

	@Test
	void removeUserPass() {
		assertTrue(login.removeUser(userOne));
	}

	@Test
	void removeUserFail() {
		assertFalse(login.removeUser(userThree));
	}

	@Test
	void testSuccessfulPasswordReset() {
		assertTrue(
				login.editPassword("UserOne", "12345AbC", "newPassword"));
	}

	@Test
	void testUserNotFound() {
		assertFalse(login.editPassword("NonExistentUser", "oldPassword",
				"newPassword"));

	}

	@Test
	void testIncorrectOldPassword() {
		assertFalse(login.editPassword(userOne, "wrongPassword",
				"newPassword"));

	}
}

