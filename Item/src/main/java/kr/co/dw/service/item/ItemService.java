package kr.co.dw.service.item;

import java.util.List;

import kr.co.dw.domain.ItemDTO;

public interface ItemService {

	void insert(ItemDTO dto);

	ItemDTO read(int iId);

	List<ItemDTO> list();

	ItemDTO updateUI(int iId);

	void update(ItemDTO iDto);

	void delete(int iId);

}
