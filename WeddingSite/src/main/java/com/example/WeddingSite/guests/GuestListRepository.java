package com.example.WeddingSite.guests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestListRepository extends JpaRepository<GuestList, Long> {
  @Query("SELECT g FROM GuestList g WHERE g.full_name = :full_name")
  Optional<GuestList> findGuestByName(@Param("full_name") String full_name);

  @Query("SELECT g FROM GuestList g WHERE g.group_pairing = :group_pairing")
  List<GuestList> findGuestByPairing(@Param("group_pairing") Integer group_pairing);
}
