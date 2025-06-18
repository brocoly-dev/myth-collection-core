package com.mesofi.myth.collection.core.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Saint Seiya Myth Cloth figurine with various attributes and characteristics. This
 * entity contains information about the figurine's type, condition, special editions, and
 * associated restocking history.
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class MythFigurine {
  private String baseName;

  private LineUp lineUp;
  private Series series;
  private Category category;

  private boolean revival;
  private boolean oce;
  private boolean metal;
  private boolean golden;
  private boolean gold;
  private boolean broken;
  private boolean plain;
  private boolean hk;
  private boolean comic;
  private boolean set;

  private Anniversary anniversary;
}
