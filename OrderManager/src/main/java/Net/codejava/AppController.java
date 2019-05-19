package Net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private OrderService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Order> listOrders = service.listAll();
		model.addAttribute("listOrders", listOrders );
		
		return "index";
	} 
	@RequestMapping("/new")
	public String showOrderForm(Model model) {
		Order order = new Order();
		model.addAttribute("order",order);
		
		return "new_order";
		
	}
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order) {
		service.save(order);
		
		return "redirect:/";
	}
	@RequestMapping("/edit/{idorders}")
	public ModelAndView showEditOrderForm(@PathVariable(name = "idorders")int idorders) {
		ModelAndView mav = new ModelAndView("edit_order");
		
		Order order = service.get(idorders);
		mav.addObject("order", order);
		
		return mav;
		
	}
	@RequestMapping("/delete/{idorders}")
	public String deleteOrder(@PathVariable(name = "idorders")int idorders){
		service.delete(idorders);
		
		return "redirect:/";
		
		
	}
}
