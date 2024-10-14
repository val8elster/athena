package com.application.athena.services;

import lombok.Getter;

@Getter
public class Logic {
    private static Logic instance;
    private final TempLogic tempLogic = new TempLogic();

    private Logic() {}

    public static Logic getInstance() {
        if(instance == null) {
            instance = new Logic();
        }
        return instance;
    }
}