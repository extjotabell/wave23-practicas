package covid19.covid19.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@NoArgsConstructor
public class ListaSintomasDto {

    ArrayList<SintomaDto> sintomas = new ArrayList<>();

    public ArrayList<SintomaDto> getSintomas() {
        return sintomas;
    }
}
