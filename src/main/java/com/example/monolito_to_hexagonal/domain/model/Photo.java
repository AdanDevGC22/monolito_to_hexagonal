package com.example.monolito_to_hexagonal.domain.model;

public class Photo {
    private String id;
    //vamos a transformar de un String base 64 a un arreglo de bytes
    private byte[] photo;

    public Photo(String id, byte[] photo) {
        this.id = id;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
