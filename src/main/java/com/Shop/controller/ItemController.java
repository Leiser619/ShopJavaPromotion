package com.Shop.controller;

import com.Shop.dto.RequestItem;
import com.Shop.model.Item;
import com.Shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping()
    public Item add(@RequestBody RequestItem requestItem){
        return itemService.add(requestItem);
    }

    @GetMapping()
    public List<Item> getAll(){
        return itemService.get();
    }
}
