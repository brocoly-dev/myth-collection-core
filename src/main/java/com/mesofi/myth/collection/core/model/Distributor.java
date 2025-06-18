package com.mesofi.myth.collection.core.model;

/**
 * Enumeration representing different distributors in the collection system. Each distributor has a
 * descriptive name that provides more detailed information about the distributor entity.
 */
public enum Distributor implements Describable {
  DAM("Distribuidora Animexico"),
  DTM("Distribuidora TM");

  /** The descriptive name of the distributor. */
  private final String description;

  /**
   * Constructs a new Distributor with the specified description.
   *
   * @param description the descriptive name of the distributor
   */
  Distributor(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
