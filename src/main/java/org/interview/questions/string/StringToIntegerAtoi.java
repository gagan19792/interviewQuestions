package org.interview.questions.string;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(stringToIntegerAtoi("-124"));
    }

//    Time : O(N)
//    SPACE : O(1)
    public static int stringToIntegerAtoi(String s){
        int sign = 1;
        int index = 0;
        int result = 0;
        int n = s.length();
        //remove space
        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        //check for + / -
        if(index < n && s.charAt(index) == '+')
        {
            sign = 1;index++;
        }
        else if(index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }


        //traverse next digit of input and stop if its non-digit
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            //check for over or underflow
            if(
                    (result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //Append digit to result
            result = 10*result+digit;
            index++;
        }

        return (sign * result);
    }
}
