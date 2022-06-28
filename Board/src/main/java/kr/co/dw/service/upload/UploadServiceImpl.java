
package kr.co.dw.service.upload;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.repository.upload.UploadDAO;

@Service
@Transactional
public class UploadServiceImpl implements UploadService{
	
	@Inject
	private UploadDAO uDao;

	@Override
	public void insert(BoardDTO bDto) {
		
		//bDto안에 있는 리스트를 하나씩 꺼내서 반복문을 돌릴 것이다
		
		List<String> list = bDto.getFilenameList();
		
		for (int i = 0; i < list.size(); i++) {
			String filename = list.get(i);
			uDao.insert(filename, bDto.getBno());
		}
	}

	@Override
	public List<String> getAllUpload(int bno) {
		// TODO Auto-generated method stub
		return uDao.getAllUpload(bno);
	}

}
