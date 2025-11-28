package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.models.IllustratorModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IllustratorService {

    public IllustratorModel createIllustrator(IllustratorModel illustrator);

    public IllustratorModel updateIllustrator(IllustratorModel illustrator,Long id);

    public IllustratorModel deleteIllustrator(Long id);

    public List<IllustratorModel> getAllIllustrators();

    public IllustratorModel findIllustratorById(Long id);
}
