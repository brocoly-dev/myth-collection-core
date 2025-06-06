package com.mesofi.myth.collection.core.model;

/**
 * Interface for objects that can provide a description of themselves. Implementing classes should
 * provide a meaningful textual description that can be used for display or identification purposes.
 */
public interface Describable {

  /**
   * Returns a textual description of this object.
   *
   * @return a string describing this object, or null if no description is available
   */
  String getDescription();
}
