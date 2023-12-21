package com.mercadolibre.userstory.service.impl;

import com.mercadolibre.userstory.dto.request.StudentDTO;
import com.mercadolibre.userstory.dto.request.SubjectDTO;
import com.mercadolibre.userstory.service.IStudentService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class StudentServiceImpl implements IStudentService {
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        double totalScore = 0.0;
        int subjectCount = studentDTO.getSubjects().size();

        for (SubjectDTO subject : studentDTO.getSubjects()) {
            double score = subject.getScore();

            totalScore += score;
        }

        double averageScore = totalScore / subjectCount;
        DecimalFormat df = new DecimalFormat("#.##");
        averageScore = Double.parseDouble(df.format(averageScore));
        String message = "El Alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + averageScore;

        studentDTO.setMessage(message);
        studentDTO.setAverageScore(averageScore);

        return studentDTO;
    }
}
