package kr.co.dw.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.repository.item.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO iDao;
}
