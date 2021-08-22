package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.FotoDao;
import dao.bean.Foto;

@Service
@Transactional
public class FotoServiceImpl implements FotoService {
	@Autowired
	private FotoDao fotoDao;
	
	@Override
	public Foto upload(Foto foto) {
		if (foto!=null && foto.getUid()!=null && foto.getFotoPath()!=null) {
			return fotoDao.insert(foto);
		}
		return null;
	}

	@Override
	public Foto delete(Foto foto) {
		if (foto!=null && foto.getId()!=null) {
			return fotoDao.delete(foto.getId());
		}
		return null;
	}

	@Override
	public Integer getFotoCount(Foto foto) {
		if (foto!=null && foto.getUid()!=null && !foto.getUid().equals(0)) {
			return fotoDao.select(foto.getUid());
		}
		return fotoDao.select();
	}

	@Override
	public List<?> getFotoList(Foto foto, Integer currentPageNum, Integer pageSize) {
		if (foto!=null && foto.getUid()!=null && !foto.getUid().equals(0)) {
			return fotoDao.select(foto.getUid(), currentPageNum, pageSize);
		}
		return fotoDao.select(currentPageNum, pageSize);
	}

	@Override
	public Foto getIndexFoto() {
		return fotoDao.random();
	}

}
