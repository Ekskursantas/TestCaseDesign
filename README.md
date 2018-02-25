# Test excercise 3 

### Equivalence classes

- 1). Make equivalences classes for the input variable for this method: 
```java
public boolean isEven(int n)
```

Equivalence classes | Test Case
------------------ | ------------------------
n % 2 != 0  | 99 is ODD
n % 2 == 0 | 100 is EVEN

------------------------

- 2). Make equivalances classes for an input variable that represents a mortgage applicant's salary. The valid range is $1000 to $75,000 pr. month.


Equivalence classes | Test Case
------------------- | ----------------
salary < 1000 | 999 is INVALID
1000 <= salary <= 75000 | 25000 is VALID
75000 < salary | 99999 is INVALID

-------------

- 3). Make equivalences classes for the input variables for this method:

```java
public static int getNumDaysinMonth(int month, int year)
```
These classes are assuming that we can not go before Christ.

Equivalance classes       | Test Case
------------------------- | -------------------
0 < month < 13   | 10 is VALID
0 > month or month > 13     | -99 or 14 is INVALID
0 <= year | 1996 is VALID
0 > year | -999 is INVALID

-----------------------

### Boundary value analysis:

- Exercise 1:

I am not sure about these boundaries.

(-infinity; +infinity) Valid boundaries

- Exercise 2:

(-infinity; 999) and (75001;+infinity) Invalid boundaries

[1000;75000] Valid boundaries

- Exercise 3:

(-infinity; 0] and [13;+infinity) Invalid boundaries

[1;12] Valid boundaries

Considering what I said before about the years, the boundaries would be:

(-infinity; 0] is INVALID

[1;+infinity) is VALID

----------------------------------------
### Decision tables

- Make a decision table for the following business case. 

Conditions:                | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
-------------------------- |:------:|:------:|:------:|:------:|
Hospital Visit          | T | F | T | F
Dedutible meet          | T | T | F | F
**Actions/Outcomes:**       | **¤** | **¤** | **¤** | **¤**
50% reimbursed          | - | Y | - | -
80% reimbursed          | Y | - | - | -
0% reimbursed           | - | - | Y | Y
-----------------------------------------

- Make a decision table for leap years.


Conditions:                | Rule 1 | Rule 2 | Rule 3 | Rule 4 |  Rule 5 | Rule 6 | Rule 7 | Rule 8 |
-------------------------- |:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|
Year Divisible by 4        | T | T | T | F | F | F | F | T | 
Year Divisble by 100       | T | T | F | F | F | T | T | F |
Year Divisble by 400       | T | F | F | F | T | T | F | T |   
**Actions/Outcomes:**      | **¤** | **¤** | **¤** | **¤** | **¤** | **¤** | **¤** | **¤** |
Leap year                  | Y | - | Y | - | - | - | - | Y |
Not Leap year              | - | Y | - | Y | Y | Y | Y | - |
-----------
### State Transition
- Exercise 1:
Make a state diagram that depicts the state of MyArrayListWithBugs.java and shows the events that cause a change from one state to another. (Black dot indicates start state)
![Alt text](Screenshot_1.png?raw=true "State Diagram")

Action | State | Next state
---------------------:| ----------- | --------------
MyArrayListWithBugs() | Starting State | Waiting State
Add(Object o) | Waiting State | Working State
add(int index, object e) | Waiting State | Working State
add(int index, object e) | Waiting State | Error State
remove(int index) | Waiting State | Working State
remove(int index) | Waiting State | Error State
get(int Index) | Waiting State | Working State
get(int index) | Waiting State | Error State
Size() | Waiting State | Working State

- State 1 -> State 2 -> State 3 -> State 4
- State 1 = Starting State
- State 2 = Waiting State
- State 3 = Working State
- State 4 = Error State




S1 = Startstate, S2 = Working, idle, ready state. S3 = Error, exception chrashed state.
----------------------
- Exercise 2:
Derive test cases from the state diagram


TC# | Testcase 
---:| ----------------------------------------------------
1 | Assert size() = 0; add(Object a1); Assert size() = 1;
2 | Assert size() = 0; add(Object a1); add(Object a2); Assert size() = 2; Assert get(1) = a2;
3 | Assert size() = 0; add(Object a1); add(Object a2); Assert size() = 2; Assert get(0) = a1; remove(0); Assert size() = 1; Assert get(0) = a2;
4 | Assert size() = 0; add(Object a1); add(Object a2); add(Object a3); add(Object a4); Assert size() = 4; Assert get(3) = a4; add(3, Object a5); Assert get(3) = a5; Assert get(4) = a4; Assert size() = 5;
5 | Assert size() = 0; add(Object a1); Assert size() = 1; Assert OutOfBounds remove(1);
6 | Assert size() = 0; add(Object a1); add(Object a2); Assert size() = 2; Assert get(0) = a1; add(0, Object a3); Assert get(0) = a3; Assert get(1) = a1; Assert size() = 3;
7 | Assert size() = 0; add(Object a1) * 10; Assert size() = 10;
8 | Assert size() = 0; add(Object a1); Assert size() = 1; Assert OutOfBounds get(1);
9 | Assert size() = 0; Assert OutOfBounds add(3, Object a1);
------------------------------------------
- Exercise 3:
Implemented Automated Unit Test With JUnit5 "Testing.java"
----------------------
- Exercise 4:
Detect, locate (and document) and fix as many errors as possible in the class.
![Alt text](Screenshot_2.png?raw=true "TestCases")

Looking at this picture we can see several issues with the implementation before hand. 
```java
if (index <= 0 || nextFree < index)
```
Because of this if statement we are unable to get the object in the index possition of 0. To fix this issue we have to remove the "=" from the first statement and add the "=" to the second statement because if there were no added object we would like to throw this exception because the nextFree = 0;

```java
for(int i = nextFree-1; i > index; i--)
```
Because of this i value we exclude the last element in the array and do not add it with the new indext. To fix it we have to remove the "-1". Also, the function is missing "nextFree++". Meaning even though we added a new value to the end of the list the "nextFree" index is still not updated.

What else caught my mind is that, even though we are aloved to add the object with a specific index. We have to make sure that the index is within the range of nextFree. Which in a sense ruins the whole point of the insertion. I would be better to make it that we create bigger arrays when the index is bigger than the size of the array and we create the new array with the length of the index.

Also, after removing the value at index. The values will be move to thre left by one and doing so the last and the next last values will be duplicates because we do not remove the last value, we only overwrite it next time we add a new value with that index.


----------------------
- Exercise 5: Consider whether a state table is more useful design technique. Comment on that.


----------------------
- Exercise 6: Make a conclusion where you specify the level of test coverage and argue for your chosen level:


----------------------
