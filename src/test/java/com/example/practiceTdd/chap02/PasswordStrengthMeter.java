package com.example.practiceTdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        if(s.length()<8){
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = meetsContainingNumberCriteria(s);
        if(!containsNum){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for(char c : s.toCharArray()){
            if(c >= '0' && c<= '9'){
                return true;
            }
        }
        return false;
    }

}
