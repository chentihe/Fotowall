package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.bean.Foto;

@Repository
public class FotoDaoImpl implements FotoDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Foto insert(Foto foto) {
		if (foto!=null && foto.getUid()!=null) {
			this.getSession().get(Foto.class, this.getSession().save(foto));
			return foto;
		}
		return null;
	}
	@Override
	public Foto delete(Integer id) {
		if(id!=null) {
			Foto foto = this.getSession().get(Foto.class, id);
			if(foto!=null) {
				this.getSession().delete(foto);
				return foto;
			}
		}
		return null;
	}
	@Override
	public Integer select() {
		String hql = "SELECT COUNT(DISTINCT(f.uid)) FROM Foto AS f";
		Integer result = this.getSession().createQuery(hql, Long.class)
			.uniqueResult()
			.intValue();
		return result;
	}
	// 查詢用戶上傳照片總數
	@Override
	public Integer select(Integer uid) {
		if (uid!=null) {
			String hql = "SELECT COUNT(f.id) FROM Foto as f WHERE f.uid = :uid";
			Integer result = this.getSession().createQuery(hql, Long.class)
				.setParameter("uid", uid)
				.uniqueResult()
				.intValue();
			return result;
		}
		return null;
	}
	// 查詢每個用戶最新上傳的照片
	@Override
	public List<Object[]> select(Integer currentPageNum, Integer pageSize) {
		List<Object[]> fotoList = new ArrayList<Object[]>();
		Foto foto = null;
		// 取得用戶id
		String hql1 ="SELECT u.id FROM User AS u";
		List<Integer> userList = this.getSession().createQuery(hql1, Integer.class)
			.setFirstResult((currentPageNum - 1) * pageSize)
			.setMaxResults(pageSize)				
			.list();
		// forEach取出用戶最新上傳照片
		for (Integer uid : userList) {
			String hql2 ="FROM Foto AS f WHERE f.uid = :id ORDER BY f.id DESC";
			foto = this.getSession().createQuery(hql2, Foto.class)
					.setParameter("id", uid)
					.setFirstResult(0)
					.setMaxResults(1)
					.uniqueResult();
			if (foto!=null) {
				Object[] fotoUser = {foto, foto.getUser()};
				fotoList.add(fotoUser);
			}
		}
		return fotoList;
	}
	// 查詢uid的照片
	@Override
	public List<Foto> select(Integer uid, Integer currentPageNum, Integer pageSize) {
		if (uid!=null && !uid.equals(0)) {
			String hql = "FROM Foto WHERE uid = :uid";
			List<Foto> result = this.getSession().createQuery(hql, Foto.class)
				.setParameter("uid", uid)
				.setFirstResult((currentPageNum - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
			return result;
		}
		return null;
	}

	@Override
	public Foto random() {
		String hql = "FROM Foto ORDER BY rand()";
		Foto result = this.getSession().createQuery(hql, Foto.class)
				.setMaxResults(1)
				.uniqueResult();
		return result;
	}

}
