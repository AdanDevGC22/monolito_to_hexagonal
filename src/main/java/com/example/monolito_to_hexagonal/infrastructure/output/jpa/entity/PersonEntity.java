package com.example.monolito_to_hexagonal.infrastructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
   // @Column(name = "nombre")
    private String name;
   // @Column(name = "apellido")
    private String lastName;
   // @Column(name = "tipo_identificacion")
    private String idType;
   // @Column(name = "numero_identificacion")
    private Long identificationNumber;
   // @Column(name = "edad")
    private String age;
    //@Column(name = "ciudad_nacimiento")
    private String cityOfBirth;
    //@Column(name = "foto_id")
    private String photoId;

}
