package com.meli.ejercicioBlog.repository;

import com.meli.ejercicioBlog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaRepository implements IEntradaRepository{
    private List<EntradaBlog> entradas;

    public EntradaRepository(){
        loadEntradas();
    }

    private void loadEntradas(){
        entradas = new ArrayList<>();
        entradas.add(new EntradaBlog("1", "TituloStandard1", "Juan perez", "12-04-2011"));
        entradas.add(new EntradaBlog("2", "TituloStandard2", "Jose perez", "23-07-2007"));
        entradas.add(new EntradaBlog("3", "TituloStandard3", "Diego perez", "05-11-2019"));
    }

    @Override
    public String create(EntradaBlog entrada) {
        if(find(entrada.getId()) != null){
            return null;
        }
        entradas.add(entrada);
        return entrada.getId();
    }

    @Override
    public EntradaBlog find(String id) {
        return entradas.stream().filter(entradaBlog -> entradaBlog.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradas;
    }
}
