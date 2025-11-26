package com.example.lab9.service.impl;
import com.example.lab9.dto.ItemDTO;
import com.example.lab9.mapper.ItemMapper;
import com.example.lab9.models.Country;
import com.example.lab9.models.Item;
import com.example.lab9.repositories.CountryRepository;
import com.example.lab9.repositories.ItemRepository;
import com.example.lab9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CountryRepository countryRepository;
    private final ItemMapper itemMapper;
    @Override
    public ItemDTO getItem(Long id){
        Item item = itemRepository.findById(id).orElse(null);
        if(Objects.isNull(item)){
            return null;
        }
        ItemDTO itemDTO = itemMapper.ItemToDTO(item);
        return itemDTO;
    }
    @Override
    public List<ItemDTO> getItems(){
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemsDTO = itemMapper.ItemToDTOList(items);
        return itemsDTO;
    }
    @Override
    public ItemDTO addItem(ItemDTO itemDTO){
        Item item = itemMapper.ItemToEntity(itemDTO);

        if(item.getManufacturer()!=null){
            Country country = countryRepository.findById(itemDTO.getManufacturer().getId()).orElseThrow();
            item.setManufacturer(country);
        }
        itemRepository.save(item);
        return itemMapper.ItemToDTO(item);
    }
    @Override
    public ItemDTO updateItem(Long id, ItemDTO itemDto){
        Item item = itemRepository.findById(id).orElse(null);
        if (Objects.isNull(item)){
            return null;
        }
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        if (itemDto.getManufacturer() != null) {
            Country country = countryRepository.findById(itemDto.getManufacturer().getId()).orElseThrow();
            item.setManufacturer(country);
        }
        itemRepository.save(item);
        return itemMapper.ItemToDTO(item);
    }
    @Override
    public boolean deleteItem(Long id){
        ItemDTO itemDTO = getItem(id);
        if(Objects.isNull(itemDTO)){
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
