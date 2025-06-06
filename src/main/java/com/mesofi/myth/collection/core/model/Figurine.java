package com.mesofi.myth.collection.core.model;

/**
 * Represents a figurine in the collection system. A figurine contains information about its base
 * name, displayable name, associated line-up, and other properties that define a collectible
 * figurine item.
 */
public class Figurine {
  private String baseName;
  private String displayableName; // This field is calculated ...
  private LineUp lineUp;
  private boolean oce;

  /**
   * Gets the base name of the figurine.
   *
   * @return the base name of the figurine
   */
  public String getBaseName() {
    return baseName;
  }

  /**
   * Sets the base name of the figurine.
   *
   * @param baseName the base name to set for the figurine
   */
  public void setBaseName(String baseName) {
    this.baseName = baseName;
  }

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

  /**
   * Gets the OCE (Original Color Edition) status of this figurine.
   *
   * @return true if this figurine is an OCE, false otherwise
   */
  public boolean isOce() {
    return oce;
  }

  /**
   * Sets the OCE (Original Color Edition) status of this figurine.
   *
   * @param oce true if this figurine is an OCE, false otherwise
   */
  public void setOce(boolean oce) {
    this.oce = oce;
  }
}
