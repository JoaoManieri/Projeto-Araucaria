package com.manieri.projetoaraucaria;

import com.manieri.projetoaraucaria.requests.hours.HoursRequest;

import java.io.IOException;

public class Main   {
    public static void main(String[] args) throws IOException {
       System.out.println("teste de mudar status");
       var o = new HoursRequest().getMonthHours();
       System.out.println(o.get("28"));
    }
}
