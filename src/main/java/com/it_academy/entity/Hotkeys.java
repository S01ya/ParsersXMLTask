package com.it_academy.entity;

public class Hotkeys {
    private String hotkeyLanguage;
    private String hotkeyMarckup;
    private  String hotkeyHypertext;

    public String getHotkeyLanguage() {
        return hotkeyLanguage;
    }

    public void setHotkeyLanguage(String hotkeyLanguage) {
        this.hotkeyLanguage = hotkeyLanguage;
    }

    public String getHotkeyMarckup() {
        return hotkeyMarckup;
    }

    public void setHotkeyMarckup(String hotkeyMarckup) {
        this.hotkeyMarckup = hotkeyMarckup;
    }

    public String getHotkeyHypertext() {
        return hotkeyHypertext;
    }

    public void setHotkeyHypertext(String hotkeyHypertext) {
        this.hotkeyHypertext = hotkeyHypertext;
    }

    @Override
    public String toString() {
        return "Hotkeys{" +
                "hotkeyLanguage='" + hotkeyLanguage + '\'' +
                ", hotkeyMarckup='" + hotkeyMarckup + '\'' +
                ", hotkeyHypertext='" + hotkeyHypertext + '\'' +
                '}';
    }
}
