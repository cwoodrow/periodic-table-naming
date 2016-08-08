# Java Code Challenge: Chemical Symbol Naming-Part One

This my quick and dirty answer to [Java Code Challenge: Chemical Symbol Naming-Part One](https://dzone.com/articles/java-code-challenge-chemical-symbol-naming-part-on).

Build 
    
    ./gradlew build
    
Usage

    java -jar build/libs/periodic-table-naming-1.0-SNAPSHOT.jar --check-rule <ELEMENT_NAME> <SYMBOL_NAME>
    java -jar build/libs/periodic-table-naming-1.0-SNAPSHOT.jar --first-element <ELEMENT_NAME>
    java -jar build/libs/periodic-table-naming-1.0-SNAPSHOT.jar --number-possibilities <ELEMENT_NAME>
    
`--check-rule` could have been better with a regex but it was tempting to do this this way since code is simple :D