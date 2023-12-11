package com.example.demo.saveItemMoney.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Target;
import java.util.Optional;

@Repository
public  interface SaveItemMoneyRepository extends JpaRepository<SaveItemMoney,Long> {

    @Query("select s from SaveItemMoney  s where s.userId=:userId and s.itemId=:itemId")
    Optional<SaveItemMoney> findByIdAndUserId(@Param("userId") Long userId, @Param("itemId") Long itemId);
}
