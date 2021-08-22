package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BCrypt;
import dao.UserDao;
import dao.bean.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User register(User user) {
		if (user!=null && user.getEmail()!=null) {
			return userDao.insert(user);
		}
		return null;
	}

	@Override
	public User login(String email, String password) {
		if (email!=null && password!=null) {
			User user = userDao.select(email);
			if (user!=null && BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
		}
		return null;
	}

}
