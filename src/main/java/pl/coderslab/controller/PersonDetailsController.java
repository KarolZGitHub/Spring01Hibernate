package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.service.PersonDetailsService;
import pl.coderslab.service.PersonService;

@Controller
public class PersonDetailsController {
    private PersonDetailsService personDetailsService;
    private PersonService personService;

    public PersonDetailsController(PersonDetailsService personDetailsService, PersonService personService) {
        this.personDetailsService = personDetailsService;
        this.personService = personService;
    }

    @GetMapping(path = "/addPersonDetails/{firstName}/{lastName}/{streetNumber}/{street}/{city}/{personId}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addPersonDetails(@PathVariable String firstName, @PathVariable String lastName, @PathVariable int streetNumber,
                                   @PathVariable String street, @PathVariable String city,@PathVariable long personId){
        Person person = personService.findById(personId);
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setPerson(person);
        personDetails.setCity(city);
        personDetailsService.create(personDetails);
        return personDetails.toString();
    }
    @GetMapping(path = "/{id}/{firstName}/{lastName}/{streetNumber}/{street}/{city}/{personId}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updatePersonDetails(@PathVariable long id,@PathVariable String firstName, @PathVariable String lastName, @PathVariable int streetNumber,
                                      @PathVariable String street, @PathVariable String city, @PathVariable long personId){
        Person person = personService.findById(personId);
        PersonDetails personDetails = personDetailsService.find(id);
        personDetails.setCity(city);
        personDetails.setStreet(street);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setLastName(lastName);
        personDetails.setFirstName(firstName);
        personDetails.setPerson(person);
        personDetailsService.update(personDetails);
        return personDetails.toString();
    }
    @GetMapping(path = "/getPersonDetails{id}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getPersonDetails(@PathVariable long id){
        return personDetailsService.find(id).toString();
    }
    @GetMapping(path = "/deletePersonDetails/{id}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deletePersonDetails(@PathVariable long id){
        personDetailsService.delete(id);
        return "Usunięto PersonDetails o id: " + id;
    }
}
