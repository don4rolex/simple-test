package com.andrew.business;

import com.andrew.dto.User;
import com.andrew.dto.UserPhoto;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Andrew
 */
public class RequestImplTest {

  private static RequestImpl sut;

  @BeforeClass
  public static void setup() {
    var requestMock = Mockito.mock(Request.class);
    sut = new RequestImpl(requestMock);

    var userPhoto = new UserPhoto();
    userPhoto.setUrl("www.dummyurl.com/dummyPhoto.png");

    var user = new User();
    user.setId("001");
    user.setPhoto("dummyPhoto.png");

    var userList = new ArrayList<User>();
    userList.add(user);

    when(requestMock.get("/users/001/photo")).thenReturn(userPhoto);
    when(requestMock.get("/users")).thenReturn(userList);
  }

  @Test
  public void getUserPhoto() {
    var photo = sut.getUserPhoto("001");
    assertEquals("www.dummyurl.com/dummyPhoto.png", photo.getUrl());
  }

  @Test
  public void getUsers() {
    var userList = sut.getUsers();
    assertEquals(1, userList.size());

    var user = userList.get(0);
    assertEquals("001", user.getId());
    assertEquals("dummyPhoto.png", user.getPhoto());
  }
}