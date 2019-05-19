package com.jwt.service;
 
import java.util.List;
 
import com.jwt.model.Item;
 
public interface ItemService {
     
    public void addItem(Item item);
 
    public List<Item> getAllItems();
 
    public void deleteItem(Integer ItemId);
 
    public Item getItem(int Itemid);
 
    public Item updateItem(Item item);
}
