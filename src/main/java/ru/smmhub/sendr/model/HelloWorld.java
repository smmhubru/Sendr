package ru.smmhub.sendr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hello_worlds")
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorld {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hello")
    private String hello;
}
