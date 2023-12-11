package com.example.demo.userItem.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem,Long> {

    @Query("select u from UserItem u where u.daily <> ''")
    List<UserItem> findDailyIsNotEmpty();


    Optional<List<UserItem>> findByTagIdAndAmountIsNull(Long tagId);


    @Query("select u from UserItem  u where u.userId=:userId and  u.itemId=:itemId and u.amount is null")
    Optional<UserItem> findByIdAndUserIdAndAmountIsNull(@Param("userId") Long userId,@Param("itemId") Long itemId);


    @Query("select u from UserItem  u where u.itemId=:itemId and u.amount is null")
    Optional<List<UserItem>> findByItemIdAndAmountIsNull(@Param("itemId") Long itemId);
}
