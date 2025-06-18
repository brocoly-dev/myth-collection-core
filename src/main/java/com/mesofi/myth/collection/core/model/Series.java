package com.mesofi.myth.collection.core.model;

/**
 * Enumeration representing different series in the Saint Seiya universe and related franchises.
 * Each series has a human-readable description that provides the full or commonly known name. This
 * enum implements the Describable interface to provide consistent access to series descriptions.
 *
 * <p>Available series include:
 *
 * <ul>
 *   <li>SAINT_SEIYA - The original Saint Seiya series
 *   <li>SAINTIA_SHO - Saint Seiya: Saintia Sho spin-off
 *   <li>SOG - Soul of Gold series
 *   <li>SS_LEGEND_OF_SANCTUARY - Saint Seiya Legend Of Sanctuary movie
 *   <li>SS_OMEGA - Saint Seiya Omega series
 *   <li>LOST_CANVAS - The Lost Canvas prequel series
 *   <li>SS_THE_BEGINNING - Saint Seiya The Beginning
 * </ul>
 */
public enum Series implements Describable {
  SAINT_SEIYA("Saint Seiya"),
  SAINTIA_SHO("Saintia Sho"),
  SOG("Soul of Gold"),
  SS_LEGEND_OF_SANCTUARY("Saint Seiya Legend Of Sanctuary"),
  SS_OMEGA("Saint Seiya Omega"),
  LOST_CANVAS("The Lost Canvas"),
  SS_THE_BEGINNING("Saint Seiya The Beginning");

  /** The descriptive name of the series. */
  private final String description;

  /**
   * Constructs a Series enum constant with the specified description.
   *
   * @param description the human-readable description of the series
   */
  Series(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
