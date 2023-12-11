package covid19.covid19.dto;

public class SintomaDto {
    private String nombre;

    public SintomaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
