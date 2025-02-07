package com.example.WeddingSite.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/guests")
@CrossOrigin(origins = "*")
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
  /**
   * http://localhost:8080/api/v1/guests/6
   * */
  public ResponseEntity<GuestList> getUserById(@PathVariable Long guest_id){
    return guestListRepository.findById(guest_id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  @GetMapping("/group/{group_pairing}")
  /**
   * http://localhost:8080/api/v1/guests/group/37
   * */
  public ResponseEntity<List<GuestList>> getUserByPairing(@PathVariable Integer group_pairing){
    List<GuestList> guests = guestListRepository.findGuestByPairing(group_pairing);
    return guests.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(guests);
  }
  @GetMapping("/name")
  /**
   * http://localhost:8080/api/v1/guests/name?full_name=Eliot Pardo
   * */
  public ResponseEntity<GuestList> getUserByName(@RequestParam String full_name){
    return guestListRepository.findGuestByName(full_name).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{guest_id}")
  /**
   * http://localhost:8080/api/v1/guests/7
   * @params
   * {
   *     "rsvp_status": false,
   *     "valet_request": false,
   *     "plus_one": true,
   *     "guest_name": "John Doe"
   * }
  * */
  public ResponseEntity<String> updateGuest(@PathVariable Long guest_id, @RequestBody GuestList request) {
    boolean updated = guestListService.updateGuest(guest_id, request);

    if(updated){
      return ResponseEntity.ok("Guest updated successfully.");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
