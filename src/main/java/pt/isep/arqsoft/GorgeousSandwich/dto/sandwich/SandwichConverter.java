package pt.isep.arqsoft.GorgeousSandwich.dto.sandwich;

import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.Designation;
import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.Sandwich;
import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.SandwichID;
import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.Stock;
import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.Type;
import pt.isep.arqsoft.GorgeousSandwich.domain.shared.Description;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SandwichConverter {

    public static SandwichDTO convertToDTO(Sandwich sandwich){
        if (sandwich.obtainSandwichID() == null){
            return new SandwichDTO(sandwich.obtainStock().obtainUnits(), sandwich.obtainType().toString(),
                    sandwich.obtainDesignation().obtainName(), sandwich.obtainDescription().obtainName());
        }
        return new SandwichDTO(sandwich.obtainSandwichID().obtainID(), sandwich.obtainStock().obtainUnits(), sandwich.obtainType().toString(),
                sandwich.obtainDesignation().obtainName(), sandwich.obtainDescription().obtainName());

    }

    public static Sandwich convertFromDTO(SandwichDTO sandwichDTO){
        String type = sandwichDTO.obtainType().toUpperCase();
        if(Type.lookupByName(type)== null){
            return null;
        }
        if(sandwichDTO.obtainSandwichId() == null) {
            return new Sandwich(Type.valueOf(type), Stock.valueOf(sandwichDTO.obtainStock()),
                    Designation.valueOf(sandwichDTO.obtainDesignation()), Description.valueOf(sandwichDTO.obtainDescription()));
        }
        return new Sandwich(Type.valueOf(type), Stock.valueOf(sandwichDTO.obtainStock()),
                Designation.valueOf(sandwichDTO.obtainDesignation()), Description.valueOf(sandwichDTO.obtainDescription()), SandwichID.valueOf(sandwichDTO.obtainSandwichId()));
    }

    public static List<SandwichDTO> convertListToDTO(List<Sandwich> sandwichList){
        List<SandwichDTO> sandwichDTOList = new ArrayList<>();
        for (Sandwich s : sandwichList){
            sandwichDTOList.add(convertToDTO(s));
        }
        return sandwichDTOList;
    }

}
