# Shamir's Secret Sharing Algorithm - Simplified Version

## Problem Statement

In this assignment, you'll work on a simplified version of Shamir's Secret Sharing algorithm.

Consider an unknown polynomial of degree `m`. You would require `m+1` roots of the polynomial to solve for the coefficients, represented as `k = m + 1`.

An unknown polynomial of degree `m` can be represented as:

f(x) = a_m * x^m + a_(m-1) * x^(m-1) + ... + a_1 * x + c

vbnet
Copy code

Where:
- `f(x)` is the polynomial function
- `m` is the degree of the polynomial
- `a_m`, `a_(m-1)`, ..., `a_1`, `c` are coefficients (real numbers)
- `a_m ≠ 0` (since it's the highest degree term, ensuring the polynomial is of degree `m`)

### Task

The task is to find the constant term `c` of the polynomial with the given roots. The points are not provided directly but in a specific format.

### Input Format

The input is provided as a JSON object with the following structure:

{
    "keys": {
        "n": <number_of_roots>,
        "k": <minimum_number_of_roots_required>
    },
    "<root_number>": {
        "base": "<base_of_encoding>",
        "value": "<encoded_value>"
    }
}
Where:

n: The number of roots provided in the JSON.
k: The minimum number of roots required to solve for the coefficients of the polynomial.
k = m + 1, where m is the degree of the polynomial.
Example Root Format
A root in the format:


"2": {
    "base": "2",
    "value": "111"
}
##Represents the point (x, y) where:

x is the key of the object (in this case, x = 2).
y is encoded using a given base (y = 111 in base 2), which must be decoded to find the corresponding y value.
#For example:

The value 111 in base 2 is decoded to 7, so the root would be (2, 7).
Methods to Solve for c
You can use any known method to find the coefficients of the polynomial, such as:

Lagrange interpolation
Matrix method
Gauss elimination
The task is to calculate the secret c using the decoded Y values and any known method.

##Assignment Checkpoints
#Read the Test Case (Input) from a Separate JSON File
Parse and read the input provided in JSON format from a separate file, which contains a series of polynomial roots.

#Decode the Y Values
Correctly decode the Y values that are encoded using different bases.

#Find the Secret (c)
Calculate the secret c using the decoded Y values and any known method.

##Constraints
All the coefficients a_m, a_(m-1), ..., a_1, c are positive integers.
The coefficients are within the range of a 256-bit number.
The minimum number of roots provided (n) will always be greater than or equal to k (the minimum number of roots required).
The degree of the polynomial (m) is determined as m = k−1, where k is provided in the input.
##Sample Test Case 1

{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": {
        "base": "10",
        "value": "4"
    },
    "2": {
        "base": "2",
        "value": "111"
    },
    "3": {
        "base": "10",
        "value": "12"
    },
    "6": {
        "base": "4",
        "value": "213"
    }
}
##Sample Test Case 2

{
    "keys": {
        "n": 10,
        "k": 7
    },
    "1": {
        "base": "6",
        "value": "13444211440455345511"
    },
    "2": {
        "base": "15",
        "value": "aed7015a346d63"
    },
    "3": {
        "base": "15",
        "value": "6aeeb69631c227c"
    },
    "4": {
        "base": "16",
        "value": "e1b5e05623d881f"
    },
    "5": {
        "base": "8",
        "value": "316034514573652620673"
    },
    "6": {
        "base": "3",
        "value": "2122212201122002221120200210011020220200"
    },
    "7": {
        "base": "3",
        "value": "20120221122211000100210021102001201112121"
    },
    "8": {
        "base": "6",
        "value": "20220554335330240002224253"
    },
    "9": {
        "base": "12",
        "value": "45153788322a1255483"
    },
    "10": {
        "base": "7",
        "value": "1101613130313526312514143"
    }
}
##Hint
Although you can't test your code against the test case in a testing environment, you can double-check it manually by solving the polynomial on paper and comparing the outputs.

