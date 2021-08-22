package service;

import dao.bean.User;

public interface UserService {

	public abstract User register(User user);
	
	public abstract User login(String email, String password);
}
