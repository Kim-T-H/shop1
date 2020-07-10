package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;
//detail.shop 요청시 호출되는 Controller
public class DetailController {
 private ShopService shopService;
 	public void setShopService(ShopService shopService) {
 		this.shopService=shopService;
 	}
 @RequestMapping
 //매개변수의 이름은 파라미터이름이 같은 경우 값이 설정.
 public ModelAndView detail(Integer id) {
	 //item : id에 해당하는 db정보를 읽어서 저장
	 Item item=shopService.getItemById(id);
	 ModelAndView mav= new ModelAndView();	//url 기본 view 설정
	 mav.addObject("item",item);
	 return mav;
 }
}
