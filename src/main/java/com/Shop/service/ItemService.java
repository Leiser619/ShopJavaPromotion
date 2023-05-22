package com.Shop.service;

import com.Shop.dto.RequestItem;
import com.Shop.model.Item;
import com.Shop.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo itemRepo;
    public Item add(RequestItem requestItem) {
        Item item=new Item();
        item.setName(requestItem.getName());
        item.setPrice(requestItem.getPrice());
        item.setCategory(requestItem.getCategory());
        return itemRepo.save(item);
    }

    public List<Item> get() {
        return itemRepo.findAll();
    }
}
