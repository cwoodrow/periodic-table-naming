package spl.gouv.council.of.atoms.periodic.table.naming;

import org.junit.Test;

import java.util.Iterator;
import java.util.SortedSet;

import static org.junit.Assert.*;
import static spl.gouv.council.of.atoms.periodic.table.naming.NamingTool.*;

public class NamingToolTest {
    @Test
    public void symbolsShouldBeRightOnGivenExamples() {
        assertTrue(checkRule("Spenglerium", "Ee"));
        assertTrue(checkRule("Zeddemorium", "Zr"));
        assertTrue(checkRule("Venkmine", "Kn"));
        assertFalse(checkRule("Stantzon", "Zt"));
        assertFalse(checkRule("Melintzum", "Nn"));
        assertFalse(checkRule("Tullium", "Ty"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidElementNameShouldCauseExceptionOnRuleChecking() {
        checkRule("a", "Ee");
    }


    @Test(expected = IllegalArgumentException.class)
    public void invalidSymbolNameShouldCauseExceptionOnRuleChecking() {
        checkRule("Spenglerium", "E");
    }


    @Test
    public void eiShouldBeFirstProposalForGozerium() {
        assertEquals("Ei", findFirstValidSymbolInAlphabeticalOrder("Gozerium"));
    }

    @Test
    public void ieShouldBeFirstProposalForSlimyrine() {
        assertEquals("Ie", findFirstValidSymbolInAlphabeticalOrder("Slimyrine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidElementNameShouldCauseExceptionOnValidSymbolFinding() {
        findFirstValidSymbolInAlphabeticalOrder("G");
    }

    @Test
    public void zuulonShouldHave11ValidSymbols() {
        assertEquals(11, howManyPossibleSymbolsForAGivenElementName("Zuulon"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidElementNameShouldCauseExceptionOnNumberOfPossibleSymbolsFinding() {
        howManyPossibleSymbolsForAGivenElementName("zuulon");
    }

    @Test(expected = IllegalArgumentException.class)
    public void symbolsNamesShouldNotHave1Letter() {
        validateSymbolName("A");
    }


    @Test(expected = IllegalArgumentException.class)
    public void symbolsNamesShouldNotHave3Letters() {
        validateSymbolName("Aaa");
    }

    @Test
    public void symbolsNamesShouldtHave2Letters() {
        validateSymbolName("Aa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void symbolsNamesShouldNotBeLowercase() {
        validateSymbolName("aa");
    }

    @Test
    public void symbolsNamesShouldBeCapitalized() {
        validateSymbolName("Aa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void elementsNamesShouldNotHave1Letter() {
        validateElementName("A");
    }

    @Test
    public void elementsNamesShouldHave2LettersOrMore() {
        validateElementName("Aa");
        validateElementName("Aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void elementsNamesShoulNotBeLowercase() {
        validateElementName("aaa");
    }

    @Test
    public void elementsNamesShouldBeCapitalized() {
        validateElementName("Aaa");
    }

    @Test
    public void threeDifferentLettersElementShouldGive3PossibleSymbolsOrderedAlphabetically() {
        SortedSet<String> allElementsSymbols = NamingTool.buildAllSymbols("Abc");
        assertEquals(3, allElementsSymbols.size());
        Iterator<String> iterator = allElementsSymbols.iterator();
        assertEquals(iterator.next(), "Ab");
        assertEquals(iterator.next(), "Ac");
        assertEquals(iterator.next(), "Bc");
    }

    @Test
    public void emptyELementNameShouldReturnEmptySet() {
        assertTrue(NamingTool.buildAllSymbols("").isEmpty());
    }


    @Test
    public void oneCharacterELementNameShouldReturnEmptySet() {
        assertTrue(NamingTool.buildAllSymbols("a").isEmpty());
    }


    @Test
    public void twoCharactersELementsNamesShouldReturnThemselves() {
        SortedSet<String> allElementsSymbols = NamingTool.buildAllSymbols("Ab");
        assertEquals(1, allElementsSymbols.size());
        assertEquals("Ab", allElementsSymbols.first());
    }
}
