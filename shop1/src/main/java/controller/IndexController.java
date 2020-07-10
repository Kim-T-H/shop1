package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;

public class IndexController {
	//shopService : logic.ShopService 객체 주입
	private ShopService shopService;
	//set 프로퍼티
	public void setShopService(ShopService shopService) {
		this.shopService =shopService;
	}
	
	@RequestMapping		// index.shop  요청시 호출되는 메서드
	public ModelAndView itemList() {
		//itemList :item 테이블에서 모든 정보 저장하고 있는 List 객체.
		List<Item> itemList =shopService.getItemList();
		//view 이름: index 설정
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);	//model 부분에 view로 전송할 data 저장
		return mav; //  data와 view 전부 들어가 있음.
	}
}
