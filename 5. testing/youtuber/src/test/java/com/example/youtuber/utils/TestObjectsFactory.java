package com.example.youtuber.utils;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.entity.EntradaBlog;

import java.util.List;

public class TestObjectsFactory {

    public static EntradaBlogDTO getOneEntradaBlogDTOValid() {
        return new EntradaBlogDTO(1, "Title", "Content", "20/12/2023");
    }

    public static List<EntradaBlog> getThreeEntradaBlogValid() {
        return List.of(
                new EntradaBlog(1, "Title", "Content", "20/12/2023"),
                new EntradaBlog(2, "Title", "Content", "21/12/2023"),
                new EntradaBlog(3, "Title", "Content", "22/12/2023")
        );
    }

    public static EntradaBlog getOneEntradaBlogValid() {
        return new EntradaBlog(1, "Title", "Content", "20/12/2023");
    }
}
