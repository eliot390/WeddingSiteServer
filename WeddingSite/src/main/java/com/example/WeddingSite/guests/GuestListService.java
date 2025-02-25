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
      throw new IllegalStateException("Guest ID '"+ guest_id +"' doesn't exist.");
    }
    guestListRepository.deleteById(guest_id);
  }

  public boolean updateGuest(Long guest_id, GuestList request){
    Optional<GuestList> userByName = guestListRepository.findById(guest_id);

    if (userByName.isPresent()) {
      GuestList guest = userByName.get();

      if (request.getRsvp_status() != null) guest.setRsvp_status(request.getRsvp_status());
      if (request.getValet_request() != null) guest.setValet_request(request.getValet_request());
      if (request.getPlus_one() != null) guest.setPlus_one(request.getPlus_one());
      if (request.getGuest_name() != null) guest.setGuest_name(request.getGuest_name());
      if (request.getGroup_pairing() != null) guest.setGroup_pairing(request.getGroup_pairing());
      if (request.getShort_comment() != null) guest.setShort_comment(request.getShort_comment());
      if (request.getSong_request() != null) guest.setSong_request(request.getSong_request());

      guestListRepository.save(guest);
      return true;
    }
    return false;
  }
}
