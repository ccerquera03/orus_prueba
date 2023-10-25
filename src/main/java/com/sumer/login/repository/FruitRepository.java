package com.sumer.login.repository;

import com.sumer.login.repository.dto.Fruit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitRepository  extends JpaRepository<Fruit, Long> {
    List<Fruit> findAll();
    Page<Fruit> findAll(Pageable pageable);
    Optional<Fruit> findFruitById(Long id);
    Optional<Fruit> findFruitByType(String type);

    void deleteById(Long id);
}
