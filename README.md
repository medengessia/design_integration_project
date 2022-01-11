# tp_tdd_medeng

This repository belongs to **Matthieu Medeng Essia**.

Informatique-Mathématiques bachelor's degree.

### Subject

This assignment aims to get ourselves accustomed with TDD process. By means of making us work on the implementation of the behaviour of banks and accounts, the purpose was to help us understand how much time we buy when we start by testing first.

#### Prerequisites

A Linux operating system providing a java compiler, available in M5 building, for instance. 

#### Installation

Import the folder from GitLab with : https://gitlab.univ-lille.fr/matthieu.medengessia.etu/tp_tdd_medeng.git

git clone 

#### Create the javadoc
Open a Terminal

```bash
..>cd src
```

```bash
../src>javadoc  `find . -name *.java` -d ../docs
```

The javadoc of the assignment is now available in the folder docs.

#### Compile the code
```bash
..>cd src
```

```bash
../src>javac ./bank/*.java -d ../classes
```

The classes are now available in the folder classes.

#### Compile the tests

```bash
..>cd test
```

```bash
../test> javac ./bank/*.java -classpath ../src;../testJt5.jar
```

Please notice that testJt5.jar is a -jar executable containing Junit5 API that you must own on your computer.

#### Run the tests

```bash
..> java -jar testJt5.jar -d test/bank
```

### Current work

Only the last question (4.5) could not have been handled.


### Distinguished elements

The most regrettable thing, even though the whole code managed to be handled with more or less efficiency, is the fact that the subject's guidance lacked of clarity, so that the creation of the first accounts was quite confusing, between tables and finally lists, for instance. 

Furthermore, the need to answer properly each very question led us to a specific way of treating each of them, when far better ways to handle the matter of accounts seemed more interesting. I mean, with more time and more reflection, an abstraction then just one list of accounts for Bank instances could have sounded much better.


### Depository tree

```bash
├── README.md
├── test
|   ├── bank
|   |   ├── BankAccountTest.java
|   |   ├── BankTest.java
|   |   ├── SavingsAccountTest.java
├── src
|   ├── bank
|   |   ├── Bank.java
|   |   ├── account
|   |   |   ├── BankAccount.java
|   |   |   ├── SavingsAccount.java
|   |   ├── util
|   |   |   ├── DebitGreaterThanBalanceException.java
|   |   |   ├── NotExistingAccountException.java
|   |   |   ├── ZeroCreditOrDebitException.java
```

