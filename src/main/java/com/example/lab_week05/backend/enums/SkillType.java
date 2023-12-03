package com.example.lab_week05.backend.enums;

public enum SkillType {
    UNSPECIFIC(0),
    TECHNICAL_SKILL(1),
    SOFT_KILL(2);
    private int value;

    private SkillType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
