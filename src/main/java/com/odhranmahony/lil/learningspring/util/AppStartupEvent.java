package com.odhranmahony.lil.learningspring.util;

import com.odhranmahony.lil.learningspring.business.ReservationService;
import com.odhranmahony.lil.learningspring.business.RoomReservation;
import com.odhranmahony.lil.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private ReservationService reservationService;
    private DateUtils dateUtils;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2021-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }
}
