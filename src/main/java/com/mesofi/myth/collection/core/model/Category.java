package com.mesofi.myth.collection.core.model;

/**
 * Represents different categories of Saint Seiya collectible figures. Each category corresponds to
 * a specific type or class of character from the Saint Seiya universe, such as Bronze Saints, Gold
 * Saints, Specters, and Gods.
 */
public enum Category implements Describable {
  V1("Bronze Saint V1"),
  V2("Bronze Saint V2"),
  V3("Bronze Saint V3"),
  V4("Bronze Saint V4"),
  V5("Bronze Saint V5"),
  SECONDARY("Bronze Secondary"),
  BLACK("Black Saint"),
  STEEL("Steel"),
  SILVER("Silver Saint"),
  GOLD("Golden Saint"),
  ROBE("God Robe"),
  SCALE("Poseidon Scale"),
  SURPLICE("Surplice Saint"),
  SPECTER("Specter"),
  JUDGE("Judge"),
  GOD("God"),
  INHERITOR("Inheritor");

  private final String description;

  /**
   * Constructs a Category with the specified description.
   *
   * @param description the human-readable description of the category
   */
  Category(String description) {
    this.description = description;
  }

  /** {@inheritDoc} */
  @Override
  public String getDescription() {
    return description;
  }
}
