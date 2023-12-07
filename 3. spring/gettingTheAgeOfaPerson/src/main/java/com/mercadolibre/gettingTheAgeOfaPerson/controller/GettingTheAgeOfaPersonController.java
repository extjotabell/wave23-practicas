package com.mercadolibre.gettingTheAgeOfaPerson.controller;

import com.mercadolibre.gettingTheAgeOfaPerson.entity.Person;
import com.mercadolibre.gettingTheAgeOfaPerson.exception.InvalidDateException;
import com.mercadolibre.gettingTheAgeOfaPerson.service.GettingTheAgeOfaPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.gettingTheAgeOfaPerson.entity.ErrorResponse;

/**
 * Controller class for handling requests related to retrieving a person's age.
 */
@RestController
@RequestMapping("/api/getAgeOfAPerson")
public class GettingTheAgeOfaPersonController {

    private final GettingTheAgeOfaPersonService gettingTheAgeOfaPersonService;

    /**
     * Constructor to initialize the GettingTheAgeOfaPersonService.
     */
    public GettingTheAgeOfaPersonController() {
        this.gettingTheAgeOfaPersonService = new GettingTheAgeOfaPersonService();
    }

    /**
     * Handles GET requests to calculate and retrieve a person's age based on the provided date.
     *
     * @param day   The day of the person's birthdate.
     * @param month The month of the person's birthdate.
     * @param year  The year of the person's birthdate.
     * @return A ResponseEntity containing the Person object with the calculated age or an error response.
     */
    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> gettingTheAgeOfaPerson(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        try {
            Person person = gettingTheAgeOfaPersonService.getPerson(day, month, year);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (InvalidDateException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Disculpe, estamos trabajando en resolver el problema. Vuelva pronto.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
