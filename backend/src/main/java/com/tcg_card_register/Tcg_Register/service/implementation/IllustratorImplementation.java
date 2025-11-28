package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.interfaces.IllustratorRepository;
import com.tcg_card_register.Tcg_Register.models.IllustratorModel;
import com.tcg_card_register.Tcg_Register.service.IllustratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IllustratorImplementation implements IllustratorService {
    @Autowired
    IllustratorRepository illusRep;

    @Override
    public IllustratorModel createIllustrator(IllustratorModel illustrator) {
        return illusRep.save(illustrator);
    }

    @Override
    public IllustratorModel updateIllustrator(IllustratorModel illustrator, Long id) {
        IllustratorModel prevUpdateIll = illusRep.findById(id).orElse(null);
        if(prevUpdateIll==null)
        {
            return null;
        }
        return illusRep.save(illustrator);
    }

    @Override
    public IllustratorModel deleteIllustrator(Long id) {
        IllustratorModel illustrator = illusRep.findById(id).orElse(null);
        if(illustrator==null)
        {
            return null;
        }else
        {
            illustrator.setStatus(2);
            return illustrator;
        }
    }

    @Override
    public List<IllustratorModel> getAllIllustrators() {
        return illusRep.findAll();
    }

    @Override
    public IllustratorModel findIllustratorById(Long id) {
        return illusRep.findById(id).orElse(null);
    }
}
