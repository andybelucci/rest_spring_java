package br.com.anderson.rest_spring_java.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.anderson.rest_spring_java.data.dto.v2.PersonDTOv2;
import br.com.anderson.rest_spring_java.model.Person;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person) {
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOtoEntity(PersonDTOv2 parseObject) {
        Person entity = new Person();
        entity.setId(parseObject.getId());
        entity.setFirstName(parseObject.getFirstName());
        entity.setLastName(parseObject.getLastName());
        // entity.setBirthDay(new Date());
        entity.setAddress(parseObject.getAddress().getClass());
        entity.setGender(parseObject.getGender());
        return entity;
    }
}
