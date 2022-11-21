package com.example.monolito_to_hexagonal.domain.model;

public class Person {
    private Long id;
    private String name;
    private String lastName;
    private String idType;
    private Long identificationNumber;
    private String age;
    private String cityOfBirth;
    private String photoId;

    public Person(Long id, String name, String lastName, String idType, Long identificationNumber, String age, String cityOfBirth, String photoId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idType = idType;
        this.identificationNumber = identificationNumber;
        this.age = age;
        this.cityOfBirth = cityOfBirth;
        this.photoId = photoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
