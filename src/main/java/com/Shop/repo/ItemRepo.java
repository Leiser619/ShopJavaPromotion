package com.Shop.repo;

import com.Shop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
    @Query(value ="SELECT * FROM items where category=:category", nativeQuery = true)
    List<Item> findAllCategory(@Param("category")int category);
    @Query(value ="DELETE FROM sets where id>0", nativeQuery = true)
    void delete1();

    @Query(value ="DELETE FROM sets_item_set where set_id>0", nativeQuery = true)
    void delete2();

    Optional<Item> findByCategory(int category);
    @Query(value ="SELECT * FROM items where category=:category AND id=:id", nativeQuery = true)
    Item findByIdAndCat(@Param("id")int id,@Param("category")int category);
}
