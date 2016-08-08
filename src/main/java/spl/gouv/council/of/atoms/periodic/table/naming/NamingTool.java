package spl.gouv.council.of.atoms.periodic.table.naming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class NamingTool {

    public static boolean checkRule(String elementName, String symbolName) {
        validateElementName(elementName);
        validateSymbolName(symbolName);

        return buildAllElementsSymbols(elementName).contains(symbolName);
    }

    public static int howManyPossibleSymbolsForAGivenElementName(String elementName) {
        validateElementName(elementName);

        return buildAllElementsSymbols(elementName).size();
    }

    public static String findFirstValidSymbolInAlphabeticalOrder(String elementName) {
        validateElementName(elementName);

        return buildAllElementsSymbols(elementName).first();
    }

    static void validateElementName(String elementName) {
        if(!elementName.matches("[A-Z][a-z]+")){
            throw new IllegalArgumentException("Elements should be capitapized alphabectical string of at least" +
                    " 2 characters, " + elementName + " is not correct");
        }
    }

    static void  validateSymbolName(String symbolName) {
        if(!symbolName.matches("[A-Z][a-z]")){
            throw new IllegalArgumentException("Symbols should be capitapized alphabectical string of exactly" +
                    " 2 characters, " + symbolName + " is not correct");
        }
    }

    static SortedSet<String> buildAllElementsSymbols(String elementName) {
        SortedSet<String> allSymbols = new TreeSet<>();

        IntStream.range(0, elementName.length())
                .forEach(index -> allSymbols.addAll(buildAllElementsSubSet(elementName, index)));

        return allSymbols;
    }

    private static Collection<String> buildAllElementsSubSet(String elementName, int index) {
        Collection<String> allSymbolsSubCollection = new ArrayList<>();

        IntStream.range(index + 1, elementName.length())
                .forEach(subIndex -> allSymbolsSubCollection.add(createSymbolsName(elementName, index, subIndex)));

        return allSymbolsSubCollection;
    }

    private static String createSymbolsName(String elementName, int index, int subIndex) {
        return valueOf(elementName.charAt(index)).toUpperCase() + valueOf(elementName.charAt(subIndex));
    }
}
