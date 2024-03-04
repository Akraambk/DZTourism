package com.demo.dztourism.Acommodation.Repository;

import com.demo.dztourism.Acommodation.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
