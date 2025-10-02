package br.com.anderson.rest_spring_java.data.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("rawtypes")
@JsonPropertyOrder({ "id", "address", "firstName", "lastName", "birthDay", "gender" })
public class PersonDTOv2 extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonProperty("first_name")

    private String firstName;
    @JsonProperty("last_name")

    private String lastName;
    private String address;

    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    public PersonDTOv2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthDay);
    }

    @SuppressWarnings("null")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonDTOv2 other = (PersonDTOv2) obj;
        return Objects.equals(id, other.id) && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName) && Objects.equals(address, other.address)
                && Objects.equals(gender, other.gender) && Objects.equals(birthDay, other.birthDay);
    }

}