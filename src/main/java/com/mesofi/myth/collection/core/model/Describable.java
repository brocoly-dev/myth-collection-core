package com.mesofi.myth.collection.core.model;

/**
 * Interface for objects that can provide a textual description of themselves. This interface
 * defines a contract for classes that need to expose descriptive information about their state or
 * purpose.
 */
public interface Describable {

  /**
   * Returns a textual description of this object.
   *
   * @return a string describing this object's state or purpose
   */
  String getDescription();
}
