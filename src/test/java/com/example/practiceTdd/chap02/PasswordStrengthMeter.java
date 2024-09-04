package com.example.practiceTdd.chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCounts = 0;
        boolean lengthEnough = s.length() >= 8;
        if (lengthEnough) {
            metCounts++;
        }
        boolean containsNum = meetsContainingNumberCriteria(s);
        if(containsNum){
            metCounts++;
        }
        boolean containsUpp = meetsContainingUppercaseCriteria(s);
        if(containsUpp){
            metCounts++;
        }

        if(metCounts == 1){
            return PasswordStrength.WEAK;
        }

        if(metCounts == 2){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

}
