package com.tcg_card_register.Tcg_Register.interfaces;

import com.tcg_card_register.Tcg_Register.models.CardsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardsRepository extends JpaRepository<CardsModel, Long> {
    CardsModel findByNameAndSetExpansionAndSetNumber(String name, UUID setExpansion, int setNumber);
}