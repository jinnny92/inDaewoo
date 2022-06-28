package kr.co.dw.repository.upload;

import java.util.List;

import kr.co.dw.domain.BoardDTO;

public interface UploadDAO {

	void insert(String filename, int bno);

	List<String> getAllUpload(int bno);

	void deleteUpload(String filename);

	

}
