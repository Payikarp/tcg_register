package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
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
    public IllustratorModel createIllustrator(IllustratorModel illustrator)
    {
        try
        {
            return illusRep.save(illustrator);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public IllustratorModel updateIllustrator(IllustratorModel illustrator) {
        IllustratorModel prevUpdateIll = illusRep.findById(illustrator.getId()).orElseThrow(() -> new ResourceNotFoundException("Illustrator not found."));
        try
        {
            return illusRep.save(illustrator);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public IllustratorModel deleteIllustrator(Long id) {
        IllustratorModel illustrator = illusRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Illustrator not found."));
        illustrator.setStatus(2);
        try
        {
            return illusRep.save(illustrator);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public List<IllustratorModel> getAllIllustrators() {
        return illusRep.findAll();
    }

    @Override
    public IllustratorModel findIllustratorById(Long id) {
        return illusRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Illustrator not found."));
    }
}
