package com.mesofi.myth.collection.core.model;

/**
 * Represents the various states of a collection item's availability and release status. Used to
 * track the lifecycle of items from initial prototype through final release.
 */
public enum Status {
  PROTOTYPE,
  UNRELEASED,
  RELEASE_TBD,
  RELEASED,
  FUTURE_RELEASE
}
