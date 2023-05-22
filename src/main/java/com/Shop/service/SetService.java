package com.Shop.service;

import com.Shop.model.Item;
import com.Shop.model.Set;
import com.Shop.repo.ItemRepo;
import com.Shop.repo.SetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SetService {
    public final ItemRepo itemRepo;
    public final SetRepo setRepo;

    public Set findAll(int category) {

        //rzczy z kategorii
        List<Item> itemsInCategory=itemRepo.findAllCategory(category);
        System.out.println("Ilosc itemow w kategorii: "+itemsInCategory.size());


        if(itemsInCategory.size()<5){
            return null;
        }else {
            return listOfId(category,itemsInCategory);
        }
    }
    public Set listOfId(int category,List<Item> itemsInCategory){
        //ilosc itemow w secie
        int quantityOfSet =2 + (int)(Math.random() * ((5 - 2) + 1));
        System.out.println("Ilosc itemow w secie:"+quantityOfSet);
        List<Long> idList = new ArrayList<>();


        //dodanie do listy id wszytkich id
        for (Item item : itemsInCategory) {
            idList.add(item.getId());
        }

        List<Item> selectedItem=new ArrayList<>();
        //wybranie kilku id i zapisanie ich
        for(int i=1;i<=quantityOfSet;i++){
            //randomowy index
            int id= (int)(Math.random() * idList.size());
            System.out.println("id itemu w liscie :"+ (idList.get(id)));


            selectedItem.add(itemRepo.findByIdAndCat(Math.toIntExact(idList.get(id)),category));
        }
        System.out.println(selectedItem);
        Set set=new Set();
        set.setNewPrice(15);
        set.setItemSet(selectedItem);
        return setRepo.save(set);
    }
}
//wielkosc setu dla kazdego wyszukuje item po kategori zapisuje do list i potem z tej listy randomowy id (po indexie listy )dodaje do kolejnej listy produktow