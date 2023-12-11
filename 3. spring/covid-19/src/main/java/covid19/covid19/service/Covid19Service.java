package covid19.covid19.service;

import covid19.covid19.dto.ListaDto;
import covid19.covid19.dto.NivelGravedadDto;
import covid19.covid19.dto.PersonaDto;
import covid19.covid19.dto.SintomaDto;
import covid19.covid19.exception.SintomaNoEncontradoException;
import covid19.covid19.model.NivelGravedad;
import covid19.covid19.model.Persona;
import covid19.covid19.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19Service {

    Sintoma sintoma1 = new Sintoma(1,"Fiebre",NivelGravedad.MEDIO);
    Sintoma sintoma2 = new Sintoma(2,"Tos",NivelGravedad.ALTO);
    Sintoma sintoma3 = new Sintoma(3,"Pérdida Olfato",NivelGravedad.ALTO);
    Sintoma sintoma4 = new Sintoma(4,"Cansancio",NivelGravedad.BAJO);
    ArrayList<Sintoma> sintomasCargados = new ArrayList<>(List.of(sintoma1,sintoma2,sintoma3,sintoma4));

    Persona persona1 = new Persona(
            1,
            "Julieta",
            "Monroe",
            45,
            new ArrayList<>(List.of(sintoma1,sintoma4)));

    Persona persona2 = new Persona(
            2,
            "Maria",
            "Lugones",
            75,
            new ArrayList<>(List.of(sintoma2,sintoma4)));

    Persona persona3 = new Persona(
            3,
            "Mateo",
            "Leguizamón",
            60,
            new ArrayList<>(List.of(sintoma1)));

    Persona persona4 = new Persona(
            4,
            "Julián",
            "Navarro",
            50,
            new ArrayList<>());

    private ArrayList<Persona> pacientes = new ArrayList<>(List.of(persona1,persona2,persona3,persona4));
    public ListaDto<SintomaDto> getSintomas(){
        ListaDto<SintomaDto> sintomasDto = new ListaDto<>();

        for(Sintoma sintoma: sintomasCargados){
            SintomaDto sintomaDto = new SintomaDto(sintoma.getNombre());
            sintomasDto.getListado().add(sintomaDto);
        }

        return sintomasDto;
    }

    public NivelGravedadDto getNivelGravedadPorNombreDeSintoma(String nombre) throws SintomaNoEncontradoException{
        Sintoma sintomaEncontrado = this.getSintomaPorNombre(nombre);
        return new NivelGravedadDto(sintomaEncontrado.getNivelGravedad());
    }

    public Sintoma getSintomaPorNombre(String nombre) throws SintomaNoEncontradoException {
        Sintoma sintomaEncontrado = this.sintomasCargados
                .stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre))
                .limit(1)
                .findFirst().orElse(null);

        if(sintomaEncontrado == null){
            String mensaje = String.format("Síntoma con nombre %s no enconrado",nombre);
            throw new SintomaNoEncontradoException(mensaje);
        }

        return sintomaEncontrado;
    }

    public ListaDto<PersonaDto> getPacientesDeRiesgo(){
        ListaDto<PersonaDto> pacientesDto = new ListaDto<>();

        for(Persona persona: this.pacientes) {
            if(persona.getEdad() >= 60 && !persona.getSintomas().isEmpty()){
                PersonaDto personaDto = new PersonaDto(persona.getNombre(), persona.getApellido());
                pacientesDto.getListado().add(personaDto);
            }
        }

        return pacientesDto;
    }
}
