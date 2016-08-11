package spl.gouv.council.of.atoms.periodic.table.naming;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.String.valueOf;

/**
 * This class implements <b>Java Code Challenge: Chemical Symbol Naming-Part One</b>
 *
 * The three methods are :
 * <ul>
 *     <li>{@link NamingTool#checkRule(String, String)} for symbol validation</li>
 *     <li>{@link NamingTool#findFirstValidSymbolInAlphabeticalOrder(String)} to find the first valid symbol for
 *         given element (bonus challenge #1)</li>
 *     <li>{@link NamingTool#howManyPossibleSymbolsForAGivenElementName(String)} to get the number of distinct
 *         valid symbols (bonus challenge #2)</li>
 * </ul>
 * <br>
 * See : <a href="https://dzone.com/articles/java-code-challenge-chemical-symbol-naming-part-on">
 *     https://dzone.com/articles/java-code-challenge-chemical-symbol-naming-part-on</a> <br>
 *
 * Basically, it builds a sorted set of all possible symbols for a given elements and uses the set to solve functions.
 */
public class NamingTool {

    /**
     * Checks if given symbol is correct for given element. <br>
     *
     * Here are the rules :
     *
     * <ul>
     *     <li>All chemical symbols must be exactly two letters, so B is not a valid symbol for Boron.</li>
     *     <li>Both letters in the symbol must appear in the element name, but the first letter of the element
     *         name does not necessarily need to appear in the symbol. So Hg is not valid for Mercury, but Cy is.</li>
     *     <li>The two letters must appear in order in the element name. So Vr is valid for Silver, but Rv is
     *         not. To be clear, both Ma and Am are valid for Magnesium, because there is both an a that appears
     *         after an m, and an m that appears after an a.</li>
     *     <li>If the two letters in the symbol are the same, it must appear twice in the element name. So Nn is
     *         valid for Xenon, but Xx and Oo are not.</li>
     * </ul>
     *
     * @param elementName element's name
     * @param symbolName symbol's name
     * @return <b>true</b> if symbol validates rules, <b>false</b> otherwise
     * @throws IllegalArgumentException if whether element's or symbol's name is not valid
     */
    public static boolean checkRule(String elementName, String symbolName) {
        validateElementName(elementName);
        validateSymbolName(symbolName);

        return buildAllSymbols(elementName).contains(symbolName);
    }

    /**
     * Returns the number of possible distinct symbols for a given element.
     *
     * @param elementName element's name
     * @return the number of possible distinct symbols for given element
     * @throws IllegalArgumentException if element's name is not valid
     */
    public static int howManyPossibleSymbolsForAGivenElementName(String elementName) {
        validateElementName(elementName);

        return buildAllSymbols(elementName).size();
    }

    /**
     * Returns the first valid symbol in alphabectical order for given element.
     *
     * @param elementName element's name
     * @return first valid symbol in alphabetical order
     * @throws IllegalArgumentException if element's name is not valid
     */
    public static String findFirstValidSymbolInAlphabeticalOrder(String elementName) {
        validateElementName(elementName);

        return buildAllSymbols(elementName).first();
    }

    static void validateElementName(String elementName) {
        if (!elementName.matches("[A-Z][a-z]+")) {
            throw new IllegalArgumentException("Elements should be capitapized alphabectical string of at least" +
                    " 2 characters, " + elementName + " is not correct");
        }
    }

    static void validateSymbolName(String symbolName) {
        if (!symbolName.matches("[A-Z][a-z]")) {
            throw new IllegalArgumentException("Symbols should be capitapized alphabectical string of exactly" +
                    " 2 characters, " + symbolName + " is not correct");
        }
    }

    static SortedSet<String> buildAllSymbols(String elementName) {
        SortedSet<String> allSymbols = new TreeSet<>();

        for (int firstLetterIndex = 0; firstLetterIndex < elementName.length() - 1; firstLetterIndex++) {
            for(int secondLetterIndex = firstLetterIndex+1; secondLetterIndex < elementName.length(); secondLetterIndex++){
                allSymbols.add(createSymbolsName(elementName, firstLetterIndex, secondLetterIndex));
            }
        }
        return Collections.unmodifiableSortedSet(allSymbols);
    }


    private static String createSymbolsName(String elementName, int firstLetterIndex, int secondLetterIndex) {
        return valueOf(elementName.charAt(firstLetterIndex)).toUpperCase() + valueOf(elementName.charAt(secondLetterIndex));
    }
}
