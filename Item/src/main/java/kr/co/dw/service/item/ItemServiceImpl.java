package kr.co.dw.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.ItemDTO;
import kr.co.dw.repository.item.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO iDao;
	
	@Override
	public void delete(int iId) {
		// TODO Auto-generated method stub
		iDao.delete(iId);
	}
	
	
	@Override
	public void update(ItemDTO iDto) {
		// TODO Auto-generated method stub
		iDao.update(iDto);
	}
	
	
	@Override
	public ItemDTO updateUI(int iId) {
		// TODO Auto-generated method stub
		return iDao.updateUI(iId);
	}
	
	
	@Override
	public List<ItemDTO> list() {
		// TODO Auto-generated method stub
		return iDao.list();
	}
	
	
	
	@Override
	public ItemDTO read(int iId) {
		// TODO Auto-generated method stub
		return iDao.read(iId);
	}
	
	
	@Override
	public void insert(ItemDTO dto) {
		// TODO Auto-generated method stub
		iDao.insert(dto);
		
	}
}
