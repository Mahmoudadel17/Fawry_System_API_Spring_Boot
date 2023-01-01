package com.MMHD.FawryServices.transactions;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class transaction {
    private final LocalDate date;
    private final LocalTime time;
    public transaction(){
        date = LocalDate.now();
        time = LocalTime.now();
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
}
