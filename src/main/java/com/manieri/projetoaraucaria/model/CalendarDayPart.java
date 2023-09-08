package com.manieri.projetoaraucaria.model;

public class CalendarDayPart {

    private String day;
    private String color;
    private boolean menu;
    private float hours;

    public CalendarDayPart(String day, String color, boolean menu, float hours) {
        this.day = day;
        this.color = color;
        this.menu = menu;
        this.hours = hours;
    }

    public String getDay() {
        return day;
    }

    public String getColor() {
        return color;
    }

    public boolean isMenu() {
        return menu;
    }

    public float getHours() {
        return hours;
    }
}
