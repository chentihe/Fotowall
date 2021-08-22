package dao;


import dao.bean.User;

public interface UserDao {
	public abstract User insert(User user);
		
	public abstract User select(String email);
	
}
