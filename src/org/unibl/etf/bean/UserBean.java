package org.unibl.etf.bean;

import org.unibl.etf.dao.UserDAO;
import org.unibl.etf.dto.User;

public class UserBean {
	
	public UserBean() {}
	
	private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	private User user = new User();
	private boolean isLoggedIn = false;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public void logIn(String username, String password) {
		
	}
	
	public void logOut() {
		
	}
	
	public void register() {
		
	}
	
	public boolean isUsernameUsed(String username) {
		return UserDAO.getInstance().readByUsername(username) != null;
	}
	
	public boolean isEmailUsed(String email) {
		return UserDAO.getInstance().readByEmail(email) != null;
	}
	
	public boolean isRegisterDataOK(String firstName, String lastName, String username, String password, String passwordRepeated, String email) {
		return (firstName != null && firstName.length() > 0 && firstName.length() < 45
				&& lastName != null && lastName.length() > 0 && lastName.length() < 45
				&& username != null && username.length() > 3 && username.length() < 45
				&& password != null && password.length() > 5 && password.length() < 45
				&& passwordRepeated != null && passwordRepeated.length() > 5 && passwordRepeated.length() < 45
				&& email != null && email.matches(EMAIL_REGEX));
	}
}
