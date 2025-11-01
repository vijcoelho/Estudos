package com.example.apidevs.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "devs-user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String cpf;

}
