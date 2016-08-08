package spl.gouv.council.of.atoms.periodic.table;


import spl.gouv.council.of.atoms.periodic.table.naming.NamingTool;

import static spl.gouv.council.of.atoms.periodic.table.naming.NamingTool.*;

public class Main {
    public static final String CHECK_RULE = "--check-rule";
    public static final String NUMBER_POSSIBILITIES = "--number-possibilities";
    public static final String FIRST_ELEMENT = "--first-element";

    public static void main(String[] args) {
        if(args.length < 2 || args.length > 3){
            printHelpAndExit();
        }

        String option = args[0];
        String elementName = args[1];
        switch (option){
            case CHECK_RULE:
                if(args.length != 3){
                    printHelpAndExit();
                }
                String symbolName = args[2];
                System.out.println(checkRule(elementName, symbolName));
                break;
            case NUMBER_POSSIBILITIES:
                System.out.println(howManyPossibleSymbolsForAGivenElementName(elementName));
                break;
            case FIRST_ELEMENT:
                System.out.println(findFirstValidSymbolInAlphabeticalOrder(elementName));
                break;
            default:
                printHelpAndExit();
        }
        System.exit(0);
    }

    private static void printHelpAndExit() {
        System.out.println("Bad command) line arguments, usage : ");
        System.out.println("    " + CHECK_RULE + " <ELEMENT_NAME> <SYMBOL_NAME>");
        System.out.println("    " + FIRST_ELEMENT + " <ELEMENT_NAME>");
        System.out.println("   " + NUMBER_POSSIBILITIES + " <ELEMENT_NAME>");
        System.exit(1);
    }
}
