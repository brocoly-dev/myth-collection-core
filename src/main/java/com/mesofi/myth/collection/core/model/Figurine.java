package com.mesofi.myth.collection.core.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Figurine extends BaseFigurine {

  @NotBlank
  @Size(min = 3, max = 20)
  private String baseName;

  private String displayableName; // This field is calculated ...

  private LineUp lineUp;
  private Series series;
  private Category category;
  private Status status; // This field is calculated ...

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

  @EqualsAndHashCode.Exclude private List<Restock> restocks; // This field is calculated
}
