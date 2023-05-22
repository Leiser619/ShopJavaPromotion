package com.Shop.controller;

import com.Shop.model.Category;
import com.Shop.model.Item;
import com.Shop.model.Set;
import com.Shop.service.ItemService;
import com.Shop.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotions")
@RequiredArgsConstructor
public class setController {
    public final int length = Category.values().length;
    private final SetService setService;

//    @Scheduled(cron = "*/10 * * * * *")
    @GetMapping
    public Set setNewSet() {
        int category =0 + (int)(Math.random() * (((length-1) - 0) + 1));
        System.out.println("kategoria: "+category);
        Set listOfItems=setService.findAll(category);
        return listOfItems;
    }
}