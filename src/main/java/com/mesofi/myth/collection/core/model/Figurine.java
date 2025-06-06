package com.mesofi.myth.collection.core.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Figurine {
  private String displayableName; // This field is calculated ...
  private LineUp lineUp;
}
