package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class ItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int iId;
	private String iName;
	private int iPrice;
	private int iDc;
	private int iCount;
	
public ItemDTO() {
	// TODO Auto-generated constructor stub
}

public ItemDTO(int iId, String iName, int iPrice, int iDc, int iCount) {
	super();
	this.iId = iId;
	this.iName = iName;
	this.iPrice = iPrice;
	this.iDc = iDc;
	this.iCount = iCount;
}

public int getiId() {
	return iId;
}

public void setiId(int iId) {
	this.iId = iId;
}

public String getiName() {
	return iName;
}

public void setiName(String iName) {
	this.iName = iName;
}

public int getiPrice() {
	return iPrice;
}

public void setiPrice(int iPrice) {
	this.iPrice = iPrice;
}

public int getiDc() {
	return iDc;
}

public void setiDc(int iDc) {
	this.iDc = iDc;
}

public int getiCount() {
	return iCount;
}

public void setiCount(int iCount) {
	this.iCount = iCount;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	return Objects.hash(iId);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ItemDTO other = (ItemDTO) obj;
	return iId == other.iId;
}

@Override
public String toString() {
	return "ItemDTO [iId=" + iId + ", iName=" + iName + ", iPrice=" + iPrice + ", iDc=" + iDc + ", iCount=" + iCount
			+ "]";
}


}
