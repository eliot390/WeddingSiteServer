package com.example.WeddingSite.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
