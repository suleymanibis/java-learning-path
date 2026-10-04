// This utility class provides methods for checking parity (even/odd) 
// and converting decimal integers into binary and hexadecimal strings, 
// demonstrating both standard arithmetic and optimized bitwise approaches.

package ObjectOrientedProgramming;

import java.io.*;
public class Manager {
    public String isEven(int a){
        int b = 1;
        int c = a & b;
        return (c == 1) ? "Odd" : "Even";
    }

    public String decimalToBinaryString(int a){
        if (a == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0){
            stringBuilder.insert(0, a % 2);
            a /= 2;
        }
        return stringBuilder.toString();
    }

    public String decimalToBinaryStringWithBitwise(int a){
        if (a == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0){
            int b = a & 1;
            stringBuilder.insert(0, b);
            a >>= 1;
        }
        return stringBuilder.toString();
    }

    public String decimalToHexadecimalString(int a){
        if (a == 0) return "0";
        String certainChars = "0123456789ABCDEF";
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0){
            int remainder = (a % 16);
            stringBuilder.insert(0, certainChars.charAt(remainder));
            a /= 16;
        }
        return stringBuilder.toString();
    }

    public String decimalToHexadecimalStringWithBitwise(int a){
        if (a == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0){
            int remainder = (a & 15);
            if (remainder < 10) stringBuilder.insert(0, remainder);
            else stringBuilder.insert(0, (char) ('A' + (remainder - 10)));
            a >>= 4;
        }
        return stringBuilder.toString();
    }
}


