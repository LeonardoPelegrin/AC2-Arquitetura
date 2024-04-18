package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name="id_setor")
    private Setor setor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PROJETO_FUNCIONARIO",
     joinColumns = { @JoinColumn(name = "FUNCIONARIO_ID")},
     inverseJoinColumns = {@JoinColumn(name = "PROJETO_ID") })
    private List<Projeto> projetos;

    public Funcionarios(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcionarios() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Funcionarios [id=" + id + ", nome=" + nome + ", projetos=" + projetos + "]";
    }

}
