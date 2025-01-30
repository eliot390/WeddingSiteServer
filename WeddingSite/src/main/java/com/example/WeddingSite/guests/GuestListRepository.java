package com.example.WeddingSite.guests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestListRepository extends JpaRepository<GuestList, Long> {
  @Query("SELECT g FROM GuestList g WHERE g.guest_name = ?1")
  Optional<GuestList> findGuestByName(String guest_name);
}
