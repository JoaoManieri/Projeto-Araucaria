package com.manieri.projetoaraucaria.requests.hours;

import com.manieri.projetoaraucaria.requests.Requests;

import java.io.IOException;

public class HoursRequest extends Requests {

    void getWorkHours() throws IOException {

        GET("/time_entries.json");


    }


}
