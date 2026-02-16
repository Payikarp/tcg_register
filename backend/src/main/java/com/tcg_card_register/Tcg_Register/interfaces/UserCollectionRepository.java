package com.tcg_card_register.Tcg_Register.interfaces;

import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCollectionRepository extends JpaRepository<UserCollectionModel, Long> {
    List<UserCollectionModel> findAllByUserId(long userId);

    UserCollectionModel findByUserIdAndId(long userId, long Id);
}
