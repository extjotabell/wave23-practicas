package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.entity.EntradaBlog;
import com.example.youtuber.exception.BlogAlreadyExistException;
import com.example.youtuber.exception.BlogDoesNotExistException;
import com.example.youtuber.repository.YoutuberRepository;
import com.example.youtuber.service.YoutuberService;
import com.example.youtuber.utils.TestObjectsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class YoutuberServiceTest {

    @Mock
    private YoutuberRepository youtuberRepository;

    @InjectMocks
    private YoutuberService youtuberService;

    @Test
    void createEntryValid() {
        youtuberService.create(TestObjectsFactory.getOneEntradaBlogDTOValid());

        verify(youtuberRepository, times(1)).create(any(EntradaBlog.class));
    }

    @Test
    void createEntryInvalid() {
        doThrow(new BlogAlreadyExistException()).when(youtuberRepository).create(any(EntradaBlog.class));

        assertThrows(BlogAlreadyExistException.class,
                () -> youtuberService.create(TestObjectsFactory.getOneEntradaBlogDTOValid()));
    }

    @Test
    void getEntryValid() {
        EntradaBlog entry = TestObjectsFactory.getOneEntradaBlogValid();

        when(youtuberRepository.get(entry.getId())).thenReturn(Optional.of(entry));

        EntradaBlogDTO entradaBlogDTO = youtuberService.get(entry.getId());

        assertEquals(entradaBlogDTO.getId(), entry.getId());
        assertEquals(entradaBlogDTO.getAutor(), entry.getAutor());
        assertEquals(entradaBlogDTO.getTitulo(), entry.getTitulo());
        assertEquals(entradaBlogDTO.getFecha(), entry.getFecha());
    }

    @Test
    void getEntryInvalid() {
        when(youtuberRepository.get(anyInt())).thenReturn(Optional.empty());

        assertThrows(BlogDoesNotExistException.class,
                () -> youtuberService.get(0));
    }

    @Test
    void getAll() {
        List<EntradaBlog> entries = TestObjectsFactory.getThreeEntradaBlogValid();

        when(youtuberRepository.getAll()).thenReturn(entries);

        List<EntradaBlogDTO> actual = youtuberService.getAll();

        assertEquals(entries.stream().map(EntradaBlogDTO::new).toList(), actual);
    }
}
