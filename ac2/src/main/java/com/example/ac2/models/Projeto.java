package com.example.ac2.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private LocalDate dataInicio;
    private LocalDate dataFim;
    

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionarios> desenvolvdores;

    public Projeto(Integer id, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }

    public Projeto() {
    }
}
