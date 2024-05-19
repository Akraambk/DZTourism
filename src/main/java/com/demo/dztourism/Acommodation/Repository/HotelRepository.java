package com.demo.dztourism.Acommodation.Repository;

import com.demo.dztourism.Acommodation.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    public List<Hotel> findByCity(String city) ;
}
