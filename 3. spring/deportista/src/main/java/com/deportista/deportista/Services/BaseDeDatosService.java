package com.deportista.deportista.Services;

import com.deportista.deportista.Entities.DeporteEntity;
import com.deportista.deportista.Entities.PersonaEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BaseDeDatosService {

    private BaseDeDatosService() {}
    public static final List<PersonaEntity> PERSONA_ENTITIES = new ArrayList<>();
    public static final List<DeporteEntity> DEPORTE_ENTITIES = new ArrayList<>();
    public static final Map<PersonaEntity, List<DeporteEntity>> joinPersonaDeporte = new HashMap<>();

    static {
        PERSONA_ENTITIES.add(new PersonaEntity("Jess", "Gu", 23));
        PERSONA_ENTITIES.add(new PersonaEntity("Alvin", "Yakitori", 30));
        PERSONA_ENTITIES.add(new PersonaEntity("Jefferson", "Gutierritos", 18));
        PERSONA_ENTITIES.add(new PersonaEntity("Hong", "Chau", 25));

        DEPORTE_ENTITIES.add(new DeporteEntity("Tiro con arco", 1));
        DEPORTE_ENTITIES.add(new DeporteEntity("Bàsquetbol", 2));
        DEPORTE_ENTITIES.add(new DeporteEntity("Karate", 3));
        DEPORTE_ENTITIES.add(new DeporteEntity("Kickboxing", 4));

        joinPersonaDeporte.put(PERSONA_ENTITIES.get(0), List.of(DEPORTE_ENTITIES.get(0)));
        joinPersonaDeporte.put(PERSONA_ENTITIES.get(1), List.of());
        joinPersonaDeporte.put(PERSONA_ENTITIES.get(2), List.of(DEPORTE_ENTITIES.get(1), DEPORTE_ENTITIES.get(2)));
        joinPersonaDeporte.put(PERSONA_ENTITIES.get(3), List.of(DEPORTE_ENTITIES.get(3), DEPORTE_ENTITIES.get(0)));
    }
}
