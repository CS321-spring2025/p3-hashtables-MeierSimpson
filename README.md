# Project #: Project Name

- Author: Meier Simpson
- Class: CS321 Section #002
- Semester: Spring 2025

## Overview

Given user input for dataSource, loadFactor and debugLevel: Implements two different hashing methods, LinearProbing and DoubleHashing and runs tests to verify hash's success.

## Reflection

This project was a lot to handle right before Spring break. I spent a lot of time revisiting the documentation to figure out what I was supposed to be doing. In hindsight, I probably could of avoided a lot of headaches by being more concise with my initial implementation (I forgot to use the positive mod code given).

One thing I liked about this project was the newer experience of writing my own driver for the project. I've never really done that before and it was a bit of a learning curve. One thing that confused me during this project was that you needed to code a twinprime generator even though those values remain stagnant. I get why we did this for learning purposes but it felt weird.

## Compiling and Using

Go into command line and run the shellscripts for run-tests.sh and generate-results.sh. NOTE: I had to use dos2unix in order to run these on my windows machine, so this might impact one's ability to run it on another machine.

## Results

Output from generate-results.sh:

Compiling the source code

Running tests on random data...with debug level 1: output in results-random.txt

Running java HashtableExperiment dataSource = 1 loadFactor = 0.5
Running java HashtableExperiment dataSource = 1 loadFactor = 0.6
Running java HashtableExperiment dataSource = 1 loadFactor = 0.7
Running java HashtableExperiment dataSource = 1 loadFactor = 0.8
Running java HashtableExperiment dataSource = 1 loadFactor = 0.9
Running java HashtableExperiment dataSource = 1 loadFactor = 0.95
Running java HashtableExperiment dataSource = 1 loadFactor = 0.99

Running tests on Date data...with debug level 1: output in results-date.txt

Running java HashtableExperiment dataSource = 2 loadFactor = 0.5
Running java HashtableExperiment dataSource = 2 loadFactor = 0.6
Running java HashtableExperiment dataSource = 2 loadFactor = 0.7
Running java HashtableExperiment dataSource = 2 loadFactor = 0.8
Running java HashtableExperiment dataSource = 2 loadFactor = 0.9
Running java HashtableExperiment dataSource = 2 loadFactor = 0.95
Running java HashtableExperiment dataSource = 2 loadFactor = 0.99

Running tests on word-list data...with debug level 1: output in results-word-list.txt

Running java HashtableExperiment dataSource = 3 loadFactor = 0.5
Running java HashtableExperiment dataSource = 3 loadFactor = 0.6
Running java HashtableExperiment dataSource = 3 loadFactor = 0.7
Running java HashtableExperiment dataSource = 3 loadFactor = 0.8
Running java HashtableExperiment dataSource = 3 loadFactor = 0.9
Running java HashtableExperiment dataSource = 3 loadFactor = 0.95
Running java HashtableExperiment dataSource = 3 loadFactor = 0.99

output from run-tests.sh:

Compiling the source code

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Running test for word-list for varying load factors
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

Running java HashtableExperiment dataSource = 3 loadFactor = 0.5

Test PASSED for linear probing and load = 0.5
Test PASSED for double probing and load = 0.5

Running java HashtableExperiment dataSource = 3 loadFactor = 0.6

Test PASSED for linear probing and load = 0.6
Test PASSED for double probing and load = 0.6

Running java HashtableExperiment dataSource = 3 loadFactor = 0.7

Test PASSED for linear probing and load = 0.7
Test PASSED for double probing and load = 0.7

Running java HashtableExperiment dataSource = 3 loadFactor = 0.8

Test PASSED for linear probing and load = 0.8
Test PASSED for double probing and load = 0.8

Running java HashtableExperiment dataSource = 3 loadFactor = 0.9

Test PASSED for linear probing and load = 0.9
Test PASSED for double probing and load = 0.9

Running java HashtableExperiment dataSource = 3 loadFactor = 0.95

Test PASSED for linear probing and load = 0.95
Test PASSED for double probing and load = 0.95

Running java HashtableExperiment dataSource = 3 loadFactor = 0.99

Test PASSED for linear probing and load = 0.99
Test PASSED for double probing and load = 0.99```

## Sources used

https://www.geeksforgeeks.org/conditional-or-ternary-operator-in-c/

https://www.baeldung.com/java-record-keyword
