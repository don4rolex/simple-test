package com.andrew.business;

import com.andrew.dto.User;
import com.andrew.dto.UserPhoto;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew
 */
public class RequestImplTest {

  private static RequestImpl sut;

  @BeforeClass
  public static void setup() {
    sut = new RequestImpl();
  }

  @Test
  public void getUserPhoto() {
    UserPhoto photo = sut.getUserPhoto("001");
    assertEquals("/users/001/photo", photo.getUrl());
  }

  @Test
  public void getUsers() {
    List<User> userList = sut.getUsers();
    assertEquals(10, userList.size());

    User user = userList.get(0);
    assertEquals("001", user.getId());
    assertEquals("/users/001/photo", user.getPhoto());
  }
}