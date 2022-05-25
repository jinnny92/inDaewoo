package kr.co.dw.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.ItemDTO;
import kr.co.dw.service.item.ItemService;

@Controller
@RequestMapping("/item")
public class ItemContrller {
 

	@Autowired
	private ItemService iService;
	
	@RequestMapping(value = "/delete/{iId}", method = RequestMethod.POST)
	public String delete(@PathVariable("iId") int iId) {
		iService.delete(iId);
		
		return "redirect:/item/list";
		
	}
	

	 @RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(ItemDTO iDto) {
			iService.update(iDto);

			return "redirect:/item/read/" + iDto.getiId();
		}
	
	
	 @RequestMapping(value = "/update/{iId}", method = RequestMethod.GET)
		public String updateUI(@PathVariable("iId")int iId, Model model) {
			
			ItemDTO iDto = iService.updateUI(iId);
			
			model.addAttribute("iDto", iDto);
			
			return "/item/update";
		}
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<ItemDTO> iList = iService.list();
		model.addAttribute("iList", iList);
		
		
		return "/item/list";
	}
	
	
	
	@RequestMapping(value = "/read/{iId}")
	public String read(@PathVariable("iId") int iId, Model model ) {
		ItemDTO iDto	= 	iService.read(iId);
		model.addAttribute("iDto", iDto);
		
		return "/item/read";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ItemDTO iDto) {
		
		
		iService.insert(iDto);
		return "redirect:/item/read/"+iDto.getiId();
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		
		return "/item/insert";
	}
	
}
