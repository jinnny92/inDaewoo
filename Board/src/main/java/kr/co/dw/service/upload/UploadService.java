
package kr.co.dw.service.upload;

import java.util.List;

import kr.co.dw.domain.BoardDTO;

public interface UploadService {

	void insert(BoardDTO bDto);

	List<String> getAllUpload(int bno);

}
