package dao;

import java.util.List;

import dao.bean.Foto;

public interface FotoDao {
	
	public abstract Foto insert(Foto foto);
	
	public abstract Foto delete(Integer id);
	
	public abstract Integer select();
	
	public abstract Integer select(Integer uid);
	
	public abstract List<Object[]> select(Integer currentPageNum, Integer pageSize);
	
	public abstract List<Foto> select(Integer uid, Integer currentPageNum, Integer pageSize);
	
	public abstract Foto random();
}
