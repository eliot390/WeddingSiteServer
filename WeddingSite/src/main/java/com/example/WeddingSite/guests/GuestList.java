package com.example.WeddingSite.guests;

import jakarta.persistence.*;

@Entity
@Table
public class GuestList {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
  @SequenceGenerator(name = "guest_seq", sequenceName = "guest_sequence", allocationSize = 1)

  private Long guest_id;
  private String full_name;
  private Boolean rsvp_status;
  private Boolean valet_request;
  private Boolean plus_one;
  private String guest_name;
  private Integer group_pairing;

  public GuestList(Long guest_id, String full_name, Boolean rsvp_status, Boolean valet_request, Boolean plus_one, String guest_name, Integer group_pairing) {
    this.guest_id = guest_id;
    this.full_name = full_name;
    this.rsvp_status = rsvp_status;
    this.valet_request = valet_request;
    this.plus_one = plus_one;
    this.guest_name = guest_name;
    this.group_pairing = group_pairing;
  }

  public GuestList(String full_name, Boolean rsvp_status, Boolean valet_request, Boolean plus_one, String guest_name, Integer group_pairing) {
    this.full_name = full_name;
    this.rsvp_status = rsvp_status;
    this.valet_request = valet_request;
    this.plus_one = plus_one;
    this.guest_name = guest_name;
    this.group_pairing = group_pairing;
  }

  public GuestList() {
  }

  public Long getGuest_id() {
    return guest_id;
  }

  public void setGuest_id(Long guest_id) {
    this.guest_id = guest_id;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public Boolean getRsvp_status() {
    return rsvp_status;
  }

  public void setRsvp_status(Boolean rsvp_status) {
    this.rsvp_status = rsvp_status;
  }

  public Boolean getValet_request() {
    return valet_request;
  }

  public void setValet_request(Boolean valet_request) {
    this.valet_request = valet_request;
  }

  public Boolean getPlus_one() {
    return plus_one;
  }

  public void setPlus_one(Boolean plus_one) {
    this.plus_one = plus_one;
  }

  public String getGuest_name() {
    return guest_name;
  }

  public void setGuest_name(String guest_name) {
    this.guest_name = guest_name;
  }

  public Integer getGroup_pairing() {
    return group_pairing;
  }

  public void setGroup_pairing(Integer group_pairing) {
    this.group_pairing = group_pairing;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
