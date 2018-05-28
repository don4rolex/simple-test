package com.andrew.business;

import java.util.concurrent.Future;

/**
 * @author Andrew
 */
public interface Request<T> {

  T get(String string);
}
