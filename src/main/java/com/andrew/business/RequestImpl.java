package com.andrew.business;

import com.andrew.dto.User;
import com.andrew.dto.UserPhoto;

import java.util.List;

/**
 * @author Andrew
 */
public class RequestImpl{

  private Request request;

  public RequestImpl(Request request) {
    this.request = request;
  }

  public UserPhoto getUserPhoto(String userId) {
    return (UserPhoto) request.get("/users/" + userId + "/photo");
  }

  public List<User> getUsers() {
    var users = (List<User>) request.get("/users");
    users.forEach(user -> {
      UserPhoto photo = getUserPhoto(user.getId());
      user.setPhoto(photo.getUrl());
    });

    return users;
  }
}
