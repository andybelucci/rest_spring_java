package br.com.anderson.rest_spring_java.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.rest_spring_java.data.dto.v1.PersonDTOv1;
import br.com.anderson.rest_spring_java.data.dto.v2.PersonDTOv2;
import br.com.anderson.rest_spring_java.exception.ResourceNotFoundException;
import br.com.anderson.rest_spring_java.mapper.custom.PersonMapper;

import static br.com.anderson.rest_spring_java.mapper.ObjectMapper.parseListObjects;
import static br.com.anderson.rest_spring_java.mapper.ObjectMapper.parseObject;
import br.com.anderson.rest_spring_java.model.Person;
import br.com.anderson.rest_spring_java.reporitory.PersonRepository;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTOv2> findAll() {

        logger.info("Finding all People!");

        return parseListObjects(repository.findAll(), PersonDTOv2.class);
    }

    public PersonDTOv2 findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDTOv2.class);
    }

    public PersonDTOv1 create(PersonDTOv1 person) {

        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTOv1.class);
    }

    public PersonDTOv2 createV2(Object parseObject) {

        logger.info("Creating one Person V2!");
        var entity = converter.convertDTOtoEntity(parseObject);

        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTOv1 update(PersonDTOv1 person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTOv1.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    public PersonDTOv2 update(PersonDTOv2 person) {

        logger.info("Updating one Person V2!");
        Person entity = converter.convertDTOtoEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }
}
