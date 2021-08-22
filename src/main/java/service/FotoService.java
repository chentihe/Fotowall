package service;

import java.util.List;

import dao.bean.Foto;

public interface FotoService {
	public abstract Foto upload(Foto foto);
	
	public abstract Foto delete(Foto foto);
	
	public abstract Integer getFotoCount(Foto foto);
	
	public abstract List<?> getFotoList(Foto foto, Integer currentPageNum, Integer pageSize);
	
	public abstract Foto getIndexFoto();
}
