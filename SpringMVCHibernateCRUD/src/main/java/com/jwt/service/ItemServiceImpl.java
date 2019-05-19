package com.jwt.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.jwt.dao.ItemDAO;
import com.jwt.model.Item;
 
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
 
    @Autowired
    private ItemDAO itemDAO;
 
    @Override
    @Transactional
    public void addItem(Item item) {
        itemDAO.addItem(item);
    }
 
    @Override
    @Transactional
    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }
 
    @Override
    @Transactional
    public void deleteItem(Integer itemId) {
        itemDAO.deleteItem(itemId);
    }
 
    public Item getItem(int itemId) {
        return itemDAO.getItem(itemId);
    }
 
    public Item updateItem(Item item) {
        // TODO Auto-generated method stub
        return itemDAO.updateItem(item);
    }
 
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
 
}