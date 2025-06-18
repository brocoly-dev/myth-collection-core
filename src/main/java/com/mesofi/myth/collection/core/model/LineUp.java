package com.mesofi.myth.collection.core.model;

/**
 * Enumeration representing different product line-ups in the Saint Seiya figure collection. Each
 * line-up has a descriptive name that provides a human-readable representation of the product
 * series.
 */
public enum LineUp implements Describable {
  MYTH_CLOTH_EX("Myth Cloth EX"),
  MYTH_CLOTH("Myth Cloth"),
  APPENDIX("Appendix"),
  SC_LEGEND("Saint Cloth Legend"),
  FIGUARTS("Figuarts"),
  FIGUARTS_ZERO("Figuarts Zero Touche Métallique"),
  SC_CROWN("Saint Cloth Crown"),
  DDP("DD Panoramation");

  /** The descriptive name of the line-up. */
  private final String description;

  /**
   * Constructs a LineUp with the specified description.
   *
   * @param description the descriptive name of the line-up
   */
  LineUp(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
