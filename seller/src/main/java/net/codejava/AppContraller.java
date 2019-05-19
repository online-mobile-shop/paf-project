package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class AppContraller {
	
	@Autowired
	private SellerService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Seller> listSellers = service.listAll();
		model.addAttribute("listSellers",listSellers);
		return "index";
		
	}
	@RequestMapping("/new")
	public String showNewSellerForm(Model model) {
		
		Seller seller = new Seller();
		model.addAttribute("seller",seller);
		return "new_seller";
		
	}
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveSeller(@ModelAttribute("seller")Seller seller) {
		service.save(seller);
		
		return "redirect:/";
		
		
	}
	@RequestMapping("/edit/{idSeller}")
	public ModelAndView showEditSellerForm(@PathVariable(name = "idSeller")int idSeller) {
		
		ModelAndView mav = new ModelAndView("edit_seller");
		
		Seller seller = service.get(idSeller);
		mav.addObject("seller",seller);
		return mav;
		
	}
	@RequestMapping("/delete/{idSeller}")
	public String deleteSeller(@PathVariable(name = "idSeller")int idSeller) {
		service.delete(idSeller);
		
		return "redirect:/";
		
	}

}
