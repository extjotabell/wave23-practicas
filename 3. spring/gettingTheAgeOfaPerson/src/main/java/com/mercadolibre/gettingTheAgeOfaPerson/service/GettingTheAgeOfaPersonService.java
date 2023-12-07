package com.mercadolibre.gettingTheAgeOfaPerson.service;

import com.mercadolibre.gettingTheAgeOfaPerson.entity.Person;
import com.mercadolibre.gettingTheAgeOfaPerson.exception.InvalidDateException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Service class for retrieving information related to a person's age.
 */
public class GettingTheAgeOfaPersonService {

    private final Person person = new Person();

    /**
     * Retrieves a Person object with calculated age based on the provided date.
     *
     * @param day   The day of the person's birthdate.
     * @param month The month of the person's birthdate.
     * @param year  The year of the person's birthdate.
     * @return A Person object with the calculated age.
     */
    public Person getPerson(String day, String month, String year) {
        convertDate(year, month, day);
        calculateAge();
        return person;
    }

    /**
     * Converts the provided day, month, and year into a LocalDate object for the Person's birthdate.
     * If the conversion fails, it throws an InvalidDateException with a user-friendly message.
     *
     * @param year  The year of the person's birthdate.
     * @param month The month of the person's birthdate.
     * @param day   The day of the person's birthdate.
     * @throws InvalidDateException If the date format is invalid.
     */
    public void convertDate(String year, String month, String day) {
        try {
            LocalDate dateOfBirth = parseDate(year, month, day);
            setPersonDateOfBirth(dateOfBirth);
        } catch (DateTimeException e) {
            throw new InvalidDateException("Formato de fechas inválidas.");
        }
    }

    /**
     * Parses the provided year, month, and day into a LocalDate object.
     * If the parsing fails, it throws an InvalidDateException with a user-friendly message.
     *
     * @param year  The year of the person's birthdate.
     * @param month The month of the person's birthdate.
     * @param day   The day of the person's birthdate.
     * @return A LocalDate object representing the person's birthdate.
     * @throws InvalidDateException If the date format is invalid.
     */
    private LocalDate parseDate(String year, String month, String day) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = String.format("%s-%s-%s", year, month, day);
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeException e) {
            throw new InvalidDateException("Formato de fechas inválidas.");
        }
    }

    /**
     * Sets the birthdate of the Person object.
     *
     * @param dateOfBirth The LocalDate object representing the person's birthdate.
     */
    private void setPersonDateOfBirth(LocalDate dateOfBirth) {
        person.setDateOfBirth(dateOfBirth);
    }


    /**
     * Calculates the age of the Person based on the birthdate and sets it in the Person object.
     */
    public void calculateAge() {
        person.setAge((int) ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()));
    }
}