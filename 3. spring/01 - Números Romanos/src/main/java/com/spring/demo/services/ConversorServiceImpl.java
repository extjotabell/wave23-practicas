package com.spring.demo.services;

import org.springframework.stereotype.Service;

@Service
public class ConversorServiceImpl implements ConversorService {
    @Override
    public String convertirDeDecimalARomano(int numeroDecimal) {
        if(numeroDecimal <=0 || numeroDecimal >3999){
            return "Número no contemplado";
        }
        String[] numRomanos = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i< numRomanos.length; i++)
            while (numeroDecimal >= valores[i]) {
                result.append(numRomanos[i]);
                numeroDecimal -= valores[i];
            }
        return result.toString();
    }
}
