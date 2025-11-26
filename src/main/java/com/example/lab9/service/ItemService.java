package com.example.lab9.service;
import com.example.lab9.dto.ItemDTO;
import java.util.List;

public interface ItemService {
    ItemDTO getItem(Long id);
    List<ItemDTO> getItems();
    ItemDTO addItem(ItemDTO itemDTO);
    ItemDTO updateItem(Long id, ItemDTO itemDTO);
    boolean deleteItem(Long id);
}

