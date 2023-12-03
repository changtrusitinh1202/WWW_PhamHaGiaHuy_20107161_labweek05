package com.example.lab_week05.backend.enums;

public enum SkillLevel {
    MASTER(1),
    PROFESSIONAL(2),
    ADVANCED(3),
    IMTERMEDIATE(4),
    BEGINER(5);

    private int value;

    private SkillLevel(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
