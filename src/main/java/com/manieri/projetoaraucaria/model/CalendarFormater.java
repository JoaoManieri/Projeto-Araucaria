package com.manieri.projetoaraucaria.model;

public class CalendarFormater {

    private int dayofWeek;
    private String dayOfMonth;

    public CalendarFormater(int dayOfWeek, String dayOfMonth) {
        this.dayofWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayofWeek() {
        return dayofWeek;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }
}
