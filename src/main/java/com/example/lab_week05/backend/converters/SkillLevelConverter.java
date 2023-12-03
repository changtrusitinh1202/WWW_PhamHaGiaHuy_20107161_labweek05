package com.example.lab_week05.backend.converters;

import com.example.lab_week05.backend.enums.SkillLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillLevel attribute) {
        if(attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public SkillLevel convertToEntityAttribute(Integer dbData) {
        if(dbData == 1)
            return  SkillLevel.MASTER;
        if(dbData == 2)
            return  SkillLevel.PROFESSIONAL;
        if(dbData == 3)
            return  SkillLevel.ADVANCED;
        if(dbData == 4)
            return  SkillLevel.IMTERMEDIATE;
        if(dbData == 5)
            return  SkillLevel.BEGINER;
        return null;
    }
}
