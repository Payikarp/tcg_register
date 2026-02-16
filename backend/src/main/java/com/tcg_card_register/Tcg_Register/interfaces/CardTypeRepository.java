package com.tcg_card_register.Tcg_Register.interfaces;

import com.tcg_card_register.Tcg_Register.models.CardTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardTypeModel, Long> {
}
