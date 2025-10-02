package br.com.anderson.rest_spring_java.data.dto.v1;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class PersonDTOv1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonDTOv1() {
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

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonDTOv1 other = (PersonDTOv1) obj;
        return Objects.equals(id, other.id) && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName) && Objects.equals(address, other.address)
                && Objects.equals(gender, other.gender);
    }

    public void setBirthDay(Date date) {

        throw new UnsupportedOperationException("Unimplemented method 'setBirthDay'");
    }

}
