package com.example.emilovich.boyscout.Controllers;

import java.util.ArrayList;

public class MorseCode {
    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
    private String[] morseSequence = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","|"};

    public ArrayList<String> getMorseSequence(String stringToMorse) {
        stringToMorse = stringToMorse.toLowerCase();
        ArrayList<String> sequence = new ArrayList<>();

        for (int i = 0; i < stringToMorse.length();i++){
            char letter = stringToMorse.charAt(i);
            for (int k = 0; k < alphabet.length; k++){
                if (letter == alphabet[k]){
                    sequence.add(morseSequence[k]);
                }
            }
        }
        return sequence;
    }
}
