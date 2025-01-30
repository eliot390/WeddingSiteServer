package com.example.WeddingSite.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/guests")
public class GuestListController {

  private final GuestListService guestListService;

  @Autowired
  public GuestListController(GuestListService guestListService) {
    this.guestListService = guestListService;
  }

  @GetMapping
  public List<GuestList> getGuests() {
    return guestListService.getGuests();
  }

  @Autowired
  private GuestListRepository guestListRepository;
  @GetMapping("/{guest_id}")
  public ResponseEntity<GuestList> getUserById(@PathVariable Long guest_id){
    return guestListRepository.findById(guest_id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public void addPlusOne(@RequestBody GuestList guest){
    guestListService.addNewGuest(guest);
  }

  @DeleteMapping(path = "{guest_id}")
  public void deleteGuest(@PathVariable("guest_id") Long guest_id){
    guestListService.deleteGuest(guest_id);
  }

  @PutMapping(path = "{guest_id}")
  /**
   * http://localhost:8080/api/v1/guests/4?rsvp_status=true&valet_request=true&plus_one=true&guest_name=Kevin
   * @param guest_id
   * @param rsvp_status
   * @param valet_request
   * @param plus_one
   * @param guest_name
   * */
  public void updateGuest(@PathVariable("guest_id") Long guest_id,
                          @RequestParam Boolean rsvp_status,
                          @RequestParam(required = false) Boolean valet_request,
                          @RequestParam(required = false) Boolean plus_one,
                          @RequestParam(required = false) String guest_name){
    guestListService.updateGuest(guest_id, rsvp_status, valet_request, plus_one, guest_name);
  }
}
