package com.demo.dztourism.Acommodation.Booking;

import com.demo.dztourism.Acommodation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {
}
