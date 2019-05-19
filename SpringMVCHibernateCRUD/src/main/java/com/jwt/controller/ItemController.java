package com.jwt.controller;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.model.Item;
import com.jwt.service.ItemService;;
 
@Controller
public class ItemController {
 
    private static final Logger logger = Logger
            .getLogger(ItemController.class);
 
    public ItemController() {
        System.out.println("ItemController()");
    }
 
    @Autowired
    private ItemService ItemService;
 
    @RequestMapping(value = "/")
    public ModelAndView listItem(ModelAndView model) throws IOException {
        List<Item> listItem = ItemService.getAllItems();
        model.addObject("listItem", listItem);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newItem", method = RequestMethod.GET)
    public ModelAndView newItem(ModelAndView model) {
        Item item = new Item();
        model.addObject("item", item);
        model.setViewName("ItemForm");
        return model;
    }
 
    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public ModelAndView saveItem(@ModelAttribute Item item) {
        if (item.getId() == 0) {// if item id is 0 then creating the
            // item other updating the item
            ItemService.addItem(item);
        } else {
            ItemService.updateItem(item);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    public ModelAndView deleteItem(HttpServletRequest request) {
        int ItemId = Integer.parseInt(request.getParameter("id"));
        ItemService.deleteItem(ItemId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editItem", method = RequestMethod.GET)
    public ModelAndView editItem(HttpServletRequest request) {
        int ItemId = Integer.parseInt(request.getParameter("id"));
        Item item = ItemService.getItem(ItemId);
        ModelAndView model = new ModelAndView("ItemForm");
        model.addObject("item", item);
 
        return model;
    }
 
}