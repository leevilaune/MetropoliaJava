package com.leevilaune.palindrome;

public class PalindromeChecker {

    public PalindromeChecker(){

    }

    public boolean isPalindrome(String word){
        if(word == null || word.isEmpty()){
            return false;
        }
        word = word.toLowerCase();
        word = word.replaceAll("[^a-z0-9]", "");
        for(int i = 0; i<=word.length()/2;i++){
            char c = word.charAt((word.length() - 1) - i);
            if(word.charAt(i) != c){
                return false;
            }
        }
        return true;
    }
}
