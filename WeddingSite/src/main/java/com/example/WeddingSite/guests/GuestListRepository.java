package com.example.WeddingSite.guests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestListRepository extends JpaRepository<GuestList, Long> {
  @Query("SELECT g FROM GuestList g WHERE g.full_name = ?1")
  Optional<GuestList> findGuestByName(String full_name);

  @Query("SELECT g FROM GuestList g WHERE g.group_pairing = ?1")
  List<GuestList> findGuestByPairing(Integer group_pairing);
}
