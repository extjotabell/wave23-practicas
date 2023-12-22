package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    // Set up mocks before each test method
    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test analyzeScores with success")
    void testAnalyzeScoresSuccess() {
        // Given
        // Set up the input studentId and the expected result
        Long studentId = 1L;
        StudentDTO expectedResult = new StudentDTO();
        Mockito.when(service.analyzeScores(studentId)).thenReturn(expectedResult);

        // When
        // Call the controller method with the given studentId
        StudentDTO responseEntity = controller.analyzeScores(studentId);

        // Then
        // Check that the result matches the expected result
        // Verify that the analyzeScores method of the service is called exactly once with the given studentId
        assertEquals(expectedResult, responseEntity);
        Mockito.verify(service, Mockito.times(1)).analyzeScores(studentId);
    }

    @Test
    @DisplayName("Test analyzeScores with non-existing studentId")
    void testAnalyzeScoresNonExistingStudent() {
        // Given
        // Set up a non-existing studentId and the expected result as null
        Long nonExistingStudentId = 2L;
        Mockito.when(service.analyzeScores(nonExistingStudentId)).thenReturn(null);

        // When
        // Call the controller method with the non-existing studentId
        StudentDTO result = controller.analyzeScores(nonExistingStudentId);

        // Then
        // Verify that the analyzeScores method of the service is called exactly once with the non-existing studentId
        // Check that the result is null
        Mockito.verify(service, Mockito.times(1)).analyzeScores(nonExistingStudentId);
        assertEquals(null, result);
    }
}
