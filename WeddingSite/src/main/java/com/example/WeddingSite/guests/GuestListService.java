package com.example.WeddingSite.guests;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestListService {
  public List<GuestList> getGuests() {
    return List.of(
            new GuestList(
                    1L, "Eliot", true, true, false, null, "1"
            )
    );
  }
}
