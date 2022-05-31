package kr.co.dw.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dw.service.item.ItemService;

@Controller
@RequestMapping("/item")
public class ItemContrller {
 
	@Autowired
	private ItemService iService;
	
}
