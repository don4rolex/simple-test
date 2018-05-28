package com.andrew.business;

/**
 * @author Andrew
 */
public interface Request<T> {

  T get(String string);
}
