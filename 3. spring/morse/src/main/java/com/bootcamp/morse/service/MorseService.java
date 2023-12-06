package com.bootcamp.morse.service;

import org.springframework.stereotype.Service;

@Service
public class MorseService {
    String[] codeMorse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
            ,".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",
            "..--..","-.-.--",".-.-.-","--..--"};
    String[] letra ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
    "1","2","3","4","5","6","7","8","9","0","?","!",".",","};
    public String decodeMorse(String messageCoded){
        String messageDecoded = "";
        String[] arrayMessageCoded = messageCoded.split(" ");

        for(int i=0;i<arrayMessageCoded.length;i++){
            for(int j=0;j<codeMorse.length;j++){
                if(arrayMessageCoded[i].compareTo(codeMorse[j]) == 0){
                    messageDecoded = messageDecoded.concat(letra[j]);
                }
            }
        }
        return messageDecoded;
    }
    public String codeMorse(String messageDecoded){
        String messageCoded = "";
        String[] arrayMessageDecoded = messageDecoded.split(" ");

        for(int i=0;i<arrayMessageDecoded.length;i++){
            for(int j=0;j<letra.length;j++){
                if(arrayMessageDecoded[i].toUpperCase().compareTo(letra[j]) == 0){
                    messageCoded = messageCoded.concat(codeMorse[j]);
                }
            }
        }
        return messageCoded;
    }
}
