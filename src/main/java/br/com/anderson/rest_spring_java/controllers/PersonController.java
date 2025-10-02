package br.com.anderson.rest_spring_java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.anderson.rest_spring_java.data.dto.v2.PersonDTOv2;
import br.com.anderson.rest_spring_java.services.PersonServices;

@RestController
@RequestMapping({ "/api/person/v2", "/person/v2" })
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE })
    public List<PersonDTOv2> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE })
    public PersonDTOv2 findById(@PathVariable("id") Long id) {
        PersonDTOv2 person = service.findById(id);
        addHateoasLinks(person);
        return person;
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE }, produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE })
    public PersonDTOv2 create(@RequestBody PersonDTOv2 person) {
        return service.createV2(person);
    }

    @PutMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE }, produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE })
    public PersonDTOv2 update(@RequestBody PersonDTOv2 person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void addHateoasLinks(PersonDTOv2 person) {
        person.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel().withType("GET"));

        person.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        person.add(linkTo(methodOn(PersonController.class).create(null)).withRel("create").withType("POST"));
        person.add(linkTo(methodOn(PersonController.class).update(null)).withRel("update").withType("PUT"));
        person.add(
                linkTo(methodOn(PersonController.class).delete(person.getId())).withRel("delete").withType("DELETE"));
    }
}
