package com.demo.dztourism.Acommodation.Email;


import lombok.Getter;



@Getter
public enum EmailTemplateName {
    ACTIVATE("activate");

    private final String name ;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
