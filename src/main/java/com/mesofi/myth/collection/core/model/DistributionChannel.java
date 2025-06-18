package com.mesofi.myth.collection.core.model;

/**
 * Represents the various distribution channels through which collectible items can be obtained.
 * Each channel has a descriptive name that provides more context about the distribution method.
 */
public enum DistributionChannel implements Describable {
  STORES("Stores"),
  WS("Tamashii Web Shop"),
  WT("Tamashii World Tour"),
  TN("Tamashii Nations"),
  TS("Tamashii Store"),
  OTHER("Other Limited Edition");

  /** The descriptive name of the distribution channel. */
  private final String description;

  /**
   * Constructs a new Distributor with the specified description.
   *
   * @param description the descriptive name of the distributor
   */
  DistributionChannel(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
