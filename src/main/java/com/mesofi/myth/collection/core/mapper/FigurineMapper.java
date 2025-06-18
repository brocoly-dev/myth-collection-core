package com.mesofi.myth.collection.core.mapper;

import com.mesofi.myth.collection.core.model.Anniversary;
import com.mesofi.myth.collection.core.model.Category;
import com.mesofi.myth.collection.core.model.Distribution;
import com.mesofi.myth.collection.core.model.DistributionChannel;
import com.mesofi.myth.collection.core.model.Distributor;
import com.mesofi.myth.collection.core.model.Figurine;
import com.mesofi.myth.collection.core.model.LineUp;
import com.mesofi.myth.collection.core.model.Series;
import com.mesofi.myth.collection.core.model.SourceFigurine;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Mapper class responsible for converting SourceFigurine objects to Figurine objects. This mapper
 * handles the transformation of raw figurine data including distribution information for different
 * markets (JPY and MXN), figurine properties, metadata, and various enumeration mappings. It also
 * provides date parsing capabilities and data validation to ensure clean object mapping.
 */
public class FigurineMapper {

  private static final DateTimeFormatter formatterMDY =
      new DateTimeFormatterBuilder()
          .appendPattern("M/d/yyyy") // Format: M/d/yyyy
          .toFormatter();

  private static final DateTimeFormatter formatterMY =
      new DateTimeFormatterBuilder()
          .appendPattern("M/yyyy") // Format: M/yyyy
          .toFormatter();

  /**
   * Converts a SourceFigurine object to a Figurine object by mapping all relevant fields including
   * distribution information for both JPY and MXN markets, figurine properties, and metadata. Sets
   * distribution objects to null if they contain no meaningful data.
   *
   * @param catalog the source figurine data to convert
   * @return a fully populated Figurine object with mapped data from the source
   */
  public Figurine toFigure(SourceFigurine catalog) {
    Figurine figurine = new Figurine();
    figurine.setBaseName(catalog.getBaseName());

    getDistribution(figurine, true).setBasePrice(toBigDecimal(catalog.getPriceJPY()));
    getDistribution(figurine, true).setFirstAnnouncementDate(toLocalDate(catalog.getAnnJPY()));
    getDistribution(figurine, true).setPreOrderDate(toLocalDate(catalog.getPreorderJPY()));
    getDistribution(figurine, true).setReleaseDate(toLocalDate(catalog.getReleaseJPY()));
    getDistribution(figurine, true).setReleaseDateConfirmed(isConfirmed(catalog.getReleaseJPY()));

    getDistribution(figurine, false).setDistributor(toDistributor(catalog.getDistributorMXN()));
    getDistribution(figurine, false).setBasePrice(toBigDecimal(catalog.getPriceMXN()));
    getDistribution(figurine, false).setPreOrderDate(toLocalDate(catalog.getPreorderMXN()));
    getDistribution(figurine, false).setReleaseDate(toLocalDate(catalog.getReleaseMXN()));
    getDistribution(figurine, false).setReleaseDateConfirmed(isConfirmed(catalog.getReleaseMXN()));

    figurine.setTamashiiUrl(catalog.getLink());
    figurine.setDistributionChannel(toDistributionChannel(catalog.getDist()));
    figurine.setLineUp(toLineUp(catalog.getLineUp()));
    figurine.setSeries(toSeries(catalog.getSeries()));
    figurine.setCategory(toCategory(catalog.getGroup()));

    figurine.setMetal(toBoolean(catalog.getMetal()));
    figurine.setOce(toBoolean(catalog.getOce()));
    figurine.setRevival(toBoolean(catalog.getRevival()));
    figurine.setPlain(toBoolean(catalog.getPlainCloth()));
    figurine.setBroken(toBoolean(catalog.getBroken()));
    figurine.setGolden(toBoolean(catalog.getGolden()));
    figurine.setGold(toBoolean(catalog.getGold()));
    figurine.setHk(toBoolean(catalog.getHk()));
    figurine.setComic(toBoolean(catalog.getManga()));
    figurine.setSet(toBoolean(catalog.getSet()));

    figurine.setAnniversary(toAnniversary(catalog.getAnniversary()));

    figurine.setOfficialImages(toList(catalog.getOfficialImages()));
    figurine.setOtherImages(toList(catalog.getOtherImages()));

    figurine.setRemarks(catalog.getRemarks());

    if (isDistributionEmpty(figurine.getDistributionJPY())) {
      figurine.setDistributionJPY(null);
    }
    if (isDistributionEmpty(figurine.getDistributionMXN())) {
      figurine.setDistributionMXN(null);
    }
    return figurine;
  }

  /**
   * Converts a comma-separated string to a list of strings. Returns null if the input string is
   * null or empty.
   *
   * @param commaSeparatedItem the comma-separated string to convert
   * @return a list of strings split by comma, or null if the input is null or empty
   */
  private List<String> toList(String commaSeparatedItem) {
    commaSeparatedItem = Optional.ofNullable(commaSeparatedItem).orElse("");
    return commaSeparatedItem.isEmpty() ? null : Arrays.asList(commaSeparatedItem.split(","));
  }

  /**
   * Converts an anniversary string to an Anniversary enum value. Returns null if the input string
   * is null, empty, or does not match any known anniversary.
   *
   * @param anniversary the anniversary string to convert
   * @return the corresponding Anniversary enum value, or null if no match is found
   */
  private Anniversary toAnniversary(String anniversary) {
    return switch (Optional.ofNullable(anniversary).orElse("")) {
      case "10" -> Anniversary.A_10;
      case "15" -> Anniversary.A_15;
      case "20" -> Anniversary.A_20;
      case "30" -> Anniversary.A_30;
      case "40" -> Anniversary.A_40;
      case "50" -> Anniversary.A_50;
      default -> null;
    };
  }

  /**
   * Converts a string value to a boolean. Returns true if the input string equals "TRUE"
   * (case-sensitive), false otherwise.
   *
   * @param value the string value to convert
   * @return true if the value equals "TRUE", false otherwise
   */
  private boolean toBoolean(String value) {
    return "TRUE".equals(value);
  }

  /**
   * Converts a group string to a Category enum value. Returns null if the input string is null,
   * empty, or does not match any known category.
   *
   * @param group the group string to convert
   * @return the corresponding Category enum value, or null if no match is found
   */
  private Category toCategory(String group) {
    return switch (Optional.ofNullable(group).orElse("")) {
      case "Bronze Saint V1" -> Category.V1;
      case "Bronze Saint V2" -> Category.V2;
      case "Bronze Saint V3" -> Category.V3;
      case "Bronze Saint V4" -> Category.V4;
      case "Bronze Saint V5" -> Category.V5;
      case "Bronze Secondary" -> Category.SECONDARY;
      case "Black Saint" -> Category.BLACK;
      case "Steel" -> Category.STEEL;
      case "Silver Saint" -> Category.SILVER;
      case "Gold Saint" -> Category.GOLD;
      case "God Robe" -> Category.ROBE;
      case "Poseidon Scale" -> Category.SCALE;
      case "Surplice Saint" -> Category.SURPLICE;
      case "Specter" -> Category.SPECTER;
      case "Judge" -> Category.JUDGE;
      case "God" -> Category.GOD;
      case "Inheritor" -> Category.INHERITOR;
      default -> null;
    };
  }

  /**
   * Converts a line-up string to a LineUp enum value. Returns null if the input string is null,
   * empty, or does not match any known line up.
   *
   * @param lineUp the line-up string to convert
   * @return the corresponding LineUp enum value, or null if no match is found
   */
  private LineUp toLineUp(String lineUp) {
    return switch (Optional.ofNullable(lineUp).orElse("")) {
      case "Myth Cloth EX" -> LineUp.MYTH_CLOTH_EX;
      case "Myth Cloth" -> LineUp.MYTH_CLOTH;
      case "Appendix" -> LineUp.APPENDIX;
      case "Saint Cloth Legend" -> LineUp.SC_LEGEND;
      case "Figuarts" -> LineUp.FIGUARTS;
      case "Saint Cloth Crown" -> LineUp.SC_CROWN;
      case "DD Panoramation" -> LineUp.DDP;
      case "Figuarts Zero Metallic Touch" -> LineUp.FIGUARTS_ZERO;
      default -> null;
    };
  }

  /**
   * Converts a series string to a Series enum value. Returns null if the input string is null,
   * empty, or does not match any known series.
   *
   * @param series the series string to convert
   * @return the corresponding Series enum value, or null if no match is found
   */
  private Series toSeries(String series) {
    return switch (Optional.ofNullable(series).orElse("")) {
      case "Saint Seiya" -> Series.SAINT_SEIYA;
      case "Saintia Sho" -> Series.SAINTIA_SHO;
      case "Soul of Gold" -> Series.SOG;
      case "Saint Seiya Legend Of Sanctuary" -> Series.SS_LEGEND_OF_SANCTUARY;
      case "Saint Seiya Omega" -> Series.SS_OMEGA;
      case "The Lost Canvas" -> Series.LOST_CANVAS;
      case "Saint Seiya The Beginning" -> Series.SS_THE_BEGINNING;

      default -> null;
    };
  }

  /**
   * Converts a distributor string to a Distributor enum value. Returns null if the input string is
   * null, empty, or does not match any known distributor.
   *
   * @param distributor the distributor string to convert
   * @return the corresponding Distributor enum value, or null if no match is found
   */
  private Distributor toDistributor(String distributor) {
    return switch (Optional.ofNullable(distributor).orElse("")) {
      case "DAM" -> Distributor.DAM;
      case "DTM" -> Distributor.DTM;

      default -> null;
    };
  }

  /**
   * Converts a distribution channel string to a DistributionChannel enum value. Returns null if the
   * input string is null, empty, or does not match any known distribution channel.
   *
   * @param distribution the distribution channel string to convert
   * @return the corresponding DistributionChannel enum value, or null if no match is found
   */
  private DistributionChannel toDistributionChannel(String distribution) {
    return switch (Optional.ofNullable(distribution).orElse("")) {
      case "Stores" -> DistributionChannel.STORES;
      case "Tamashii Web Shop" -> DistributionChannel.WS;
      case "Tamashii World Tour" -> DistributionChannel.WT;
      case "Tamashii Nations" -> DistributionChannel.TN;
      case "Tamashii Store" -> DistributionChannel.TS;
      case "Other Limited Edition" -> DistributionChannel.OTHER;

      default -> null;
    };
  }

  /**
   * Determines if a Distribution object is considered empty by checking if it is null or if all its
   * relevant fields are null. A distribution is considered empty when the distributor, base price,
   * first announcement date, pre-order date, release date, and release date confirmation are all
   * null.
   *
   * @param distribution the Distribution object to check for emptiness
   * @return true if the distribution is null or all its relevant fields are null, false otherwise
   */
  private boolean isDistributionEmpty(Distribution distribution) {
    return Objects.isNull(distribution)
        || Objects.isNull(distribution.getDistributor())
            && Objects.isNull(distribution.getBasePrice())
            && Objects.isNull(distribution.getFirstAnnouncementDate())
            && Objects.isNull(distribution.getPreOrderDate())
            && Objects.isNull(distribution.getReleaseDate())
            && Objects.isNull(distribution.getReleaseDateConfirmed());
  }

  /**
   * Determines if a date string represents a confirmed date based on its length. Returns null if
   * the input string is null or empty. A date is considered confirmed if its length is not 6 or 7
   * characters (which typically represent partial dates like M/yyyy or MM/yyyy formats).
   *
   * @param date the date string to check for confirmation status
   * @return true if the date is confirmed (length != 6 or 7), false if unconfirmed, or null if
   *     input is empty
   */
  private Boolean isConfirmed(String date) {
    date = Optional.ofNullable(date).orElse("");
    if (date.isEmpty()) {
      return null;
    } else {
      return !(date.length() == 6 || date.length() == 7);
    }
  }

  /**
   * Converts a currency amount string to a BigDecimal object. Returns null if the input string is
   * null, empty, or represents zero value (¥0). Otherwise, removes the currency symbol and commas
   * before converting to BigDecimal.
   *
   * @param amount the currency amount string to convert (expected format: ¥1,234)
   * @return the converted BigDecimal, or null if the input is null, empty, or zero
   */
  private BigDecimal toBigDecimal(String amount) {
    amount = Optional.ofNullable(amount).orElse("");
    return (amount.isEmpty() || amount.equals("¥0"))
        ? null
        : new BigDecimal(amount.substring(1).replaceAll(",", ""));
  }

  /**
   * Converts a date string to a LocalDate object. Returns null if the input string is null or
   * empty, otherwise attempts to parse the date using supported formats.
   *
   * @param date the date string to convert
   * @return the converted LocalDate, or null if the input is null or empty
   * @throws IllegalArgumentException if the date string cannot be parsed with any supported format
   */
  private LocalDate toLocalDate(String date) {
    date = Optional.ofNullable(date).orElse("");
    return date.isEmpty() ? null : tryParse(date);
  }

  /**
   * Attempts to parse a date string using multiple date formats. First tries to parse as a full
   * date (M/d/yyyy format), then falls back to year-month format (M/yyyy) with day set to 1 if the
   * first attempt fails.
   *
   * @param input the date string to parse
   * @return the parsed LocalDate
   * @throws IllegalArgumentException if the input cannot be parsed with any supported format
   */
  private LocalDate tryParse(String input) {
    try {
      // Try the first format
      return LocalDate.parse(input, formatterMDY);
    } catch (DateTimeParseException e1) {
      try {
        // If parsing fails, try the second format
        return YearMonth.parse(input, formatterMY).atDay(1);
      } catch (DateTimeParseException e2) {
        // If both parsing attempts fail, throw an exception
        throw new IllegalArgumentException("Invalid date format: " + input);
      }
    }
  }

  /**
   * Retrieves or creates a Distribution object for the given figurine based on currency type. If
   * the distribution doesn't exist for the specified currency, a new one is created and set.
   *
   * @param figurine the figurine to get or create distribution for
   * @param jpy true to get JPY distribution, false to get MXN distribution
   * @return the Distribution object for the specified currency
   */
  private Distribution getDistribution(Figurine figurine, boolean jpy) {
    if (jpy) {
      if (Objects.isNull(figurine.getDistributionJPY())) {
        Distribution distribution = new Distribution();
        figurine.setDistributionJPY(distribution);
      }
      return figurine.getDistributionJPY();
    } else {
      if (Objects.isNull(figurine.getDistributionMXN())) {
        Distribution distribution = new Distribution();
        figurine.setDistributionMXN(distribution);
      }
      return figurine.getDistributionMXN();
    }
  }
}
