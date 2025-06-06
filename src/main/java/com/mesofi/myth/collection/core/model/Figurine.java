package com.mesofi.myth.collection.core.model;

/**
 * Represents a collectible figurine in the collection system. This class encapsulates the core
 * properties and behavior of a figurine item.
 */
public class Figurine {
  private String displayableName; // This field is calculated ...
  private LineUp lineUp;

  /**
   * Gets the displayable name of the figurine. This is a calculated field that provides a
   * human-readable representation of the figurine.
   *
   * @return the displayable name of the figurine
   */
  public String getDisplayableName() {
    return displayableName;
  }

  /**
   * Sets the displayable name of the figurine. This method updates the calculated field that
   * provides a human-readable representation of the figurine.
   *
   * @param displayableName the displayable name to set for the figurine
   */
  public void setDisplayableName(String displayableName) {
    this.displayableName = displayableName;
  }

  /**
   * Gets the line-up associated with this figurine.
   *
   * @return the line-up that this figurine belongs to
   */
  public LineUp getLineUp() {
    return lineUp;
  }

  /**
   * Sets the line up associated with this figurine.
   *
   * @param lineUp the line-up to associate with this figurine
   */
  public void setLineUp(LineUp lineUp) {
    this.lineUp = lineUp;
  }
}
