package Security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserLoginTest {
    static String userOne = "UserOne";
    static String userOnePass = "12345AbC";
    static String userTwo = "UserTwo";
    static String userTwoPass = "cBa54321!";
    static String userThree = "NonExistentUser";

    @BeforeAll
    public static void setUp() {
        UserLogin.addUser(userOne, userOnePass);
    }

    @Test
    void addUserPass() {
        assertTrue(UserLogin.addUser(userTwo, userTwoPass));
    }
    
    @Test 
    void addUserFail() {
    	UserLogin.addUser(userOne, userOnePass);
    	assertFalse(UserLogin.addUser(userOne, userOnePass));
    }
    
    @Test
    void addUserFailPassword() {
    	assertFalse(UserLogin.addUser(userThree, ""));
    }
    
    @Test
    void loginTestPass() {
    	assertTrue(UserLogin.login(userOne, userOnePass));
    }
    
    @Test
    void loginTestFailUserError() {
    	assertFalse(UserLogin.login(userThree, userOnePass));
    }
    
    @Test
    void loginTestFailPasswordError() {
    	assertFalse(UserLogin.login(userOne, userTwoPass));
    }
    
    @Test
    void removeUserPass() {
    	assertTrue(UserLogin.removeUser(userOne));
    }
    
    @Test
    void removeUserFail() {
    	assertFalse(UserLogin.removeUser(userThree));
    }
    
    @Test
    void testSuccessfulPasswordReset() {
        assertTrue(UserLogin.editPassword("UserOne", "12345AbC", "newPassword"));
    }

    @Test
    void testUserNotFound() {
        assertFalse(UserLogin.editPassword("NonExistentUser", "oldPassword", "newPassword"));
      
    }

    @Test
    void testIncorrectOldPassword() {
        assertFalse(UserLogin.editPassword(userOne, "wrongPassword", "newPassword"));
       
    }
}
