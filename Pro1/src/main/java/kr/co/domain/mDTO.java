package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class mDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	
	public mDTO() {
		// TODO Auto-generated constructor stub
	}

	public mDTO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		mDTO other = (mDTO) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "mDTO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
