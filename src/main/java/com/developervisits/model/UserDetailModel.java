package com.developervisits.model;


import com.developervisits.constraint.CommPreference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class UserDetailModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @NotNull(message = "First name cannot be missing or empty")
  @Size(min = 2, message = "First name must not be less than 2 characters")
  private String firstName;

  @NotNull(message = "Last name cannot be missing or empty")
  @Size(min = 2, message = "Last name must not be less than 2 characters")
  private String lastName;

  @NotNull(message = "Email is a required field")
  @Email(message = "Email must be a valid")
  private String email;

  @NotNull(message = "Password is a required field")
  @Size(
      min = 8,
      max = 16,
      message =
          "Password must be equal to or greater than 8 characters and less than 16 characters")
  private String password;

  @NotEmpty(message = "Communication preference is required")
  @CommPreference
  private String commPreference;

  @ElementCollection
  private List<@NotEmpty String> mobileDevices;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCommPreference() {
    return commPreference;
  }

  public void setCommPreference(String commPreference) {
    this.commPreference = commPreference;
  }

  public List<String> getMobileDevices() {
    return mobileDevices;
  }

  public void setMobileDevices(List<String> mobileDevices) {
    this.mobileDevices = mobileDevices;
  }
}