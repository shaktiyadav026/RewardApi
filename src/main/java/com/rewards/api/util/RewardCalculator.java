package com.rewards.api.util;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Utility class to calculate reward points for transactions and
 * extract month names in a readable format.
 */
public class RewardCalculator {

    /**
     * Calculates reward points based on transaction amount.
     *
     * @param amount Transaction amount
     * @return Reward points earned
     */
    public static int calculatePoints(double amount) {
        if (amount <= 50) return 0;
        if (amount <= 100) return (int)(amount - 50);
        return (int)((amount - 100) * 2 + 50);
    }

    /**
     * Returns the full month name (e.g., January) from the given date.
     *
     * @param date LocalDate of the transaction
     * @return Month name in English
     */
    public static String getMonthName(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
