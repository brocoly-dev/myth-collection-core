package com.mesofi.myth.collection.core.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class for figurine entities containing common properties and metadata. This class serves as
 * a foundation for different types of figurines in the collection system.
 *
 * <p>All fields except the core identifying properties are excluded from equality checks to focus
 * comparison on essential figurine characteristics rather than metadata.
 */
@Setter
@Getter
@EqualsAndHashCode
public class BaseFigurine {

  @EqualsAndHashCode.Exclude @Valid private Distribution distributionJPY;
  @EqualsAndHashCode.Exclude @Valid private Distribution distributionMXN;

  @Size(max = 35)
  @EqualsAndHashCode.Exclude
  private String tamashiiUrl;

  @EqualsAndHashCode.Exclude @Valid private DistributionChannel distributionChannel;

  @EqualsAndHashCode.Exclude private List<String> officialImages;
  @EqualsAndHashCode.Exclude private List<String> otherImages;
  @EqualsAndHashCode.Exclude private String remarks;
}
