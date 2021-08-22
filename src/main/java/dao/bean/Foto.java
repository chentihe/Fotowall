package dao.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FOTO")
public class Foto implements Serializable{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="UID")
	private Integer uid;
	@Column(name="FOTO_PATH")
	private String fotoPath;
	
	@ManyToOne
	@JoinColumn(
			name="UID",
			referencedColumnName = "ID",
			insertable = false,
			updatable = false
			)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFotoPath() {
		return fotoPath;
	}
	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}
	@Override
	public String toString() {
		return "Foto [id=" + id + ", uid=" + uid + ", fotoPath=" + fotoPath + "]";
	}
	
}
