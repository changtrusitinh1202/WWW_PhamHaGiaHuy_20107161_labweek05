package com.example.lab_week05.backend.converters;

import com.example.lab_week05.backend.enums.SkillType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SkillTypeConverter implements AttributeConverter<SkillType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillType attribute) {
        if(attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public SkillType convertToEntityAttribute(Integer dbData) {
        if(dbData == 0)
            return SkillType.UNSPECIFIC;
        if(dbData == 1)
            return SkillType.TECHNICAL_SKILL;
        if(dbData == 2)
            return SkillType.SOFT_KILL;
        return null;
    }
}
