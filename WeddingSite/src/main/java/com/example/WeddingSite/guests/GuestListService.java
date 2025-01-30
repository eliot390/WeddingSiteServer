package com.example.WeddingSite.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GuestListService {

  private final GuestListRepository guestListRepository;

  @Autowired
  public GuestListService(GuestListRepository guestListRepository) {
    this.guestListRepository = guestListRepository;
  }

  public List<GuestList> getGuests() {
    return guestListRepository.findAll();
  }

  public void addNewGuest(GuestList guestList) {
    Optional<GuestList> userByName = guestListRepository.findGuestByName(guestList.getFull_name());
    if (userByName.isPresent()){
      throw new IllegalStateException("Guest has already been invited");
    }
    guestListRepository.save(guestList);
  }

  public void deleteGuest(Long guest_id) {
    boolean exists = guestListRepository.existsById(guest_id);
    if(!exists){
      throw new IllegalStateException("Guest ID '"+guest_id+"' doesn't exist.");
    }
    guestListRepository.deleteById(guest_id);
  }

  public void updateGuest(Long guest_id, Boolean rsvp_status, Boolean valet_request, Boolean plus_one, String guest_name) {
    GuestList guestList = guestListRepository.findById(guest_id).orElseThrow(() -> new IllegalStateException("Guest doesn't exist."));
    if (rsvp_status != null) {
      guestList.setRsvp_status(rsvp_status);
    }
    if (valet_request != null) {
      guestList.setValet_request(valet_request);
    }
    if (plus_one != null) {
      guestList.setPlus_one(plus_one);
    }
    if (guest_name != null && !guest_name.trim().isEmpty()) {
      guestList.setGuest_name(guest_name);
    }

    guestListRepository.save(guestList);
  }
}
