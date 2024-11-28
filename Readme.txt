Basic Power Operation
1. testPositiveBoundary:
    tests the positive boundary i.e it tests the basic to power operation with positive integers. This is the basic
    functionality of this program

Zero Handling
2. testZeroExponent:
    Testing that any base raised to 0 is 1, this is a basic mathematical rule, tested for both positive and negative exponents

3. testBaseZeroPositiveExponent: Verifies that 0 raised to any positive power equals 0

4. testZeroBaseExponent: Special case testing 0^0, which should return 1 by mathematical convention

Edge Cases
5. testBaseOne:
    Testing that base 1 with any exponent returns 1, also a mathematical rule, tested for very large exponents as well

6. testNegativeBase:
    Testing a negative base, in maths negative number mulitplied odd times is negative and multiplied even times is positive
    exponent is basically repeated multiplication, this test verifies this.

Caching Verification & Perfromance Tests
7. testCaching: Measures execution time of repeated calculations to verify caching mechanism:
First call: calculates 3^10
Second call: should be faster due to cache

Multiple Operations
8. testMultipleCalls: Tests sequential power calculations with base 2 and increasing exponents

Integer Limits Boundary Tests
9. testLargeBase: Tests overflow prevention with Integer.MAX_VALUE as base

10. testMaxAllowedResult:
    testing the max integer allowed without causing overflow, this is checking the limits of the java datatypes

11. testMinIntegerBase:
    this is a culmination of exponent 0, base 1 and max allowed result cases, we are additionally throwing an exception when\
    the exponent gives an answer which causes overflow

Boundary Conditions
12. testBoundaryExponent: Tests boundary conditions for exponents:
- Zero exponent, a^0 = 1 where a is an element of naturals numbers
- One exponent, a^0 = a where a is an element of naturals numbers
- Negative exponent should throw IllegalArgumentException

Code Coverage Analysis:
92% overall coverage
50% branch coverage
12 test methods covering 64 lines of code
Each test is designed to verify specific aspects of the power calculation function, from basic functionality to edge cases and error conditions, ensuring robust operation of the toPower method.