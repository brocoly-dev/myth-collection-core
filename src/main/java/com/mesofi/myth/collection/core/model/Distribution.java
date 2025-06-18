package com.mesofi.myth.collection.core.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the distribution information for a collectible item, including pricing, distributor
 * details, and important dates in the distribution lifecycle.
 */
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Distribution {
  @Valid private Distributor distributor;
  @NotNull private BigDecimal basePrice;
  private BigDecimal finalPrice; // This field is calculated ...
  private LocalDate firstAnnouncementDate;
  @NotNull private LocalDate preOrderDate;
  @NotNull private LocalDate releaseDate;
  @NotNull private Boolean releaseDateConfirmed;
}
