package com.manieri.projetoaraucaria.requests.hours;

import com.manieri.projetoaraucaria.requests.Requests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HoursRequest extends Requests {
    public Map getMonthHours() throws IOException {

        LocalDate hoje = LocalDate.now();
        YearMonth esteMes = YearMonth.from(hoje);
        LocalDate startDate = esteMes.atDay(1);
        LocalDate endDate = esteMes.atEndOfMonth();
        GET("time_entries.json?start_date=" + startDate + "&end_date=" + endDate);

        Map<Integer, Float> monthHours = new HashMap<>();
        Random random = new Random();

        for (int dia = 1; dia <= 30; dia++) {
            int horas = random.nextInt(24);
            monthHours.put(dia, (float) horas);
        }

        return monthHours;
    }
}