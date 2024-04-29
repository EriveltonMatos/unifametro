package com.crud.produto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "descricao")
    private String descricao;

}
