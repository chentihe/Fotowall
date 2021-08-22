package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.bean.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User insert(User user) {
		if (user!=null && user.getEmail()!=null && user.getPassword()!=null) {
			User temp = this.getSession().get(User.class, user.getEmail());
			if (temp==null) { 
				user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
				this.getSession().save(user);
				return this.getSession().get(User.class, user.getEmail());
			}
		}
		return null;
	}

	@Override
	public User select(String email) {
		if (email!=null) {
			return this.getSession().get(User.class, email);
		}
		return null;
	}

}
