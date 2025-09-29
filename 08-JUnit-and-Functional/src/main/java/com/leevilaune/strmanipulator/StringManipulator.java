package com.leevilaune.strmanipulator;

/**
 * A utility class for basic string manipulation operations.
 * Provides methods to concatenate strings, get string length,
 * change case, and check for substrings.
 */
public class StringManipulator {

    /**
     * Concatenates two strings.
     *
     * @param str1 the first string to concatenate
     * @param str2 the second string to concatenate
     * @return the concatenated string, or an empty string if either input is null
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        return str1 + str2;
    }

    /**
     * Finds the length of a string.
     *
     * @param str the string whose length is to be determined
     * @return the length of the string, or 0 if the string is null
     */
    public int findLength(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    /**
     * Converts a string to uppercase.
     *
     * @param str the string to convert
     * @return the uppercase version of the string, or an empty string if the input is null
     */
    public String convertToUpperCase(String str) {
        if (str == null) {
            return "";
        }
        return str.toUpperCase();
    }

    /**
     * Converts a string to lowercase.
     *
     * @param str the string to convert
     * @return the lowercase version of the string, or an empty string if the input is null
     */
    public String convertToLowerCase(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase();
    }

    /**
     * Checks if a string contains a given substring.
     *
     * @param str the string to search in
     * @param subStr the substring to search for
     * @return true if the string contains the substring, false if either is null or not found
     */
    public boolean containsSubstring(String str, String subStr) {
        if (str == null || subStr == null) {
            return false;
        }
        return str.contains(subStr);
    }
}