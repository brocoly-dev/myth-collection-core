package com.mesofi.myth.collection.core.model;

/**
 * Represents anniversary milestones for collectible items. Each anniversary value corresponds to a
 * specific year milestone that may be significant for collectors or special editions.
 */
public enum Anniversary implements Describable {
  A_10("10"),
  A_15("15"),
  A_20("20"),
  A_30("30"),
  A_40("40"),
  A_50("50");

  private final String description;

  /**
   * Constructs an Anniversary with the specified description.
   *
   * @param description the description of the anniversary
   */
  Anniversary(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
