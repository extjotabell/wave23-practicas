package org.meli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {
    Map<String, String> equivalences = new HashMap<>();

    public MorseController(){
        equivalences.put(".-", "A");
        equivalences.put("-...", "B");
        equivalences.put("-.-.", "C");
        equivalences.put("-..", "D");
        equivalences.put(".", "E");
        equivalences.put("..-.", "F");
        equivalences.put("--.", "G");
        equivalences.put("....", "H");
        equivalences.put("..", "I");
        equivalences.put(".---", "J");
        equivalences.put("-.-", "K");
        equivalences.put(".-..", "L");
        equivalences.put("--", "M");
        equivalences.put("-.", "N");
        equivalences.put("---", "O");
        equivalences.put(".--.", "P");
        equivalences.put("--.-", "Q");
        equivalences.put(".-.", "R");
        equivalences.put("...", "S");
        equivalences.put("-", "T");
        equivalences.put("..-", "U");
        equivalences.put("...-", "V");
        equivalences.put(".--", "W");
        equivalences.put("-..-", "X");
        equivalences.put("-.--", "Y");
        equivalences.put("--..", "Z");
        equivalences.put(".----", "1");
        equivalences.put("..---", "2");
        equivalences.put("...--", "3");
        equivalences.put("....-", "4");
        equivalences.put(".....", "5");
        equivalences.put("-....", "6");
        equivalences.put("--...", "7");
        equivalences.put("---..", "8");
        equivalences.put("----.", "9");
        equivalences.put("-----", "0");
    }

    @GetMapping("/decode")
    public String decodeMorse(@RequestBody String morse){
        String[] wordsMorse = morse.split("   ");
        StringBuilder sb = new StringBuilder();

        for (String s : wordsMorse) {
            String[] charMorse = s.split(" ");
            for (String string : charMorse) {
                sb.append(equivalences.get(string));
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    @GetMapping("/encode")
    public String encodeMorse(@RequestBody String texto){
        texto = texto.toUpperCase();
        String[] wordsTexto = texto.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String wordTexto : wordsTexto) {
            String[] charsTexto = wordTexto.split("");
            for (String letraTexto : charsTexto) {
                sb.append(getKeyFromEquivalences(letraTexto));
                sb.append(" ");
            }
            sb.append("  ");
        }

        sb.delete(sb.length()-3, sb.length());
        return sb.toString();
    }
    public String getKeyFromEquivalences(String value) {
        for (Map.Entry<String, String> entry : equivalences.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
