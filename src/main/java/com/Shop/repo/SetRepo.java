package com.Shop.repo;

import com.Shop.model.Item;
import com.Shop.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepo extends JpaRepository<Set,Long> {
}
