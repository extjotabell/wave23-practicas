package org.example;

import java.util.*;

public class Career {
    private Map<Integer, Category> categories;
    private Set<Inscription> registrations;

    public Career() {
        this.categories = new HashMap<>();
        this.registrations = new HashSet<>();
    }

    public void addCategory(Integer id, Category category) {
        category.setId(id);
        this.categories.put(id, category);
    }

    public void registerParticipant(Participant participant, Integer idCategory) {
        Category categoria = getCategory(idCategory);
        Integer montoAbonar = getAmountToPay(participant.getAge(), idCategory);
        Inscription inscripcion = new Inscription(categoria, participant, montoAbonar);
        this.registrations.add(inscripcion);

    }

    private Integer getAmountToPay(Integer ageParticipant, Integer idCategory) {
        for (Map.Entry<Integer, Category> categoria : categories.entrySet()) {
            if (categoria.getKey().equals(idCategory)) {
                return ageParticipant >= 18 ? categoria.getValue().getHigherAmount() : categoria.getValue().getSmallerAmount();
            }
        }
        return 0;
    }

    private Category getCategory(Integer idCategory) {
        for (Map.Entry<Integer, Category> categoria : categories.entrySet()) {
            if (categoria.getKey().equals(idCategory)) {
                return categoria.getValue();
            }
        }
        return null;
    }

    public Set<Inscription> getParticipants() {
        return this.registrations;
    }

    public Set<Inscription> getParticipants(Integer idCategory) {
        Set<Inscription> aux = new HashSet<>();
        for (Inscription inscripcion : registrations) {
            if (inscripcion.getCategory().getId().equals(idCategory)) {
                aux.add(inscripcion);
            }
        }
        return aux;
    }

    public void unsuscribeParticipant(Participant participant) {
        Inscription aux = null;
        for (Inscription inscription : registrations) {
            if (inscription.getParticipant().getDni().equals(participant.getDni())) {
                aux = inscription;
            }
        }
        this.registrations.remove(aux);
    }

    public List<String> calculateTotalAmountPerCategory() {
        Map<Integer, Integer> categoryTotals = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            categoryTotals.put(i, 0);
        }

        for (Inscription inscription : registrations) {
            int categoryId = inscription.getCategory().getId();
            int currentTotal = categoryTotals.get(categoryId);
            int newTotal = currentTotal + inscription.getAmountToPay();
            categoryTotals.put(categoryId, newTotal);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : categoryTotals.entrySet()) {
            int categoryId = entry.getKey();
            int totalAmount = entry.getValue();
            result.add("Categoria " + categoryId + ": " + totalAmount);
        }

        return result;
    }
}
