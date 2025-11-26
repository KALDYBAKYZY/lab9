package com.example.lab9.mapper;
import com.example.lab9.dto.ItemDTO;
import com.example.lab9.models.Item;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel="spring")
public interface ItemMapper {
    Item ItemToEntity(ItemDTO itemDTO);
    ItemDTO ItemToDTO(Item item);
    List<ItemDTO> ItemToDTOList(List<Item> items);
}
