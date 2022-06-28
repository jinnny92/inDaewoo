package kr.co.dw.repository.readcnt;

public interface ReadCntDao {

	void insert(String ip, int bno);

	
	String read(String ip, int bno);
}
