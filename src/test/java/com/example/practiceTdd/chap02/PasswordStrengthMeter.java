package com.example.practiceTdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        if(s == null || s.isEmpty()){
            return PasswordStrength.INVALID;
        }

        if(s.length()<8){
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = meetsContainingNumberCriteria(s);
        if(!containsNum){
            return PasswordStrength.NORMAL;
        }

        boolean containsUpper = meetsContainingUppercaseCriteria(s);
        if(!containsUpper){
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

    private boolean meetsContainingUppercaseCriteria(String s){
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

}
