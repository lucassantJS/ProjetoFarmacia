package org.example.farmacia.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ReceitaEletrônica")
public class ReceitaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int senha;

    @Column(nullable = false)
    private double autenticacao;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private MedicoModel medico;

    public ReceitaModel() {}

    public ReceitaModel(int senha, double autenticacao, MedicoModel medico) {
        this.senha = senha;
        this.autenticacao = autenticacao;
        this.medico = medico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(double autenticacao) {
        this.autenticacao = autenticacao;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "ReceitaModel{" +
                "id=" + id +
                ", senha=" + senha +
                ", autenticacao=" + autenticacao +
                ", medico=" + medico +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senha, autenticacao, medico);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceitaModel that = (ReceitaModel) o;
        return id == that.id &&
                senha == that.senha &&
                Double.compare(that.autenticacao, autenticacao) == 0 &&
                Objects.equals(medico, that.medico);
    }
}
