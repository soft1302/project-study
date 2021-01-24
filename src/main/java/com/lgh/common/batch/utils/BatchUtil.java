package com.lgh.common.batch.utils;

public abstract class BatchUtil {
  private BatchUtil() {
  }

  public static boolean shouldDoBatch(final String statementId) {
    return statementId.startsWith("batch", statementId.lastIndexOf('.') + 1);
  }
}
