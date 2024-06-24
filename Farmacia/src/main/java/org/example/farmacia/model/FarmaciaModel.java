package org.example.farmacia.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Farmacia")
public class FarmaciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnpj;

    @Column(nullable = false)
    private int senha;

    @Column(nullable = false)
    private String validaReceita;

    public FarmaciaModel() {}

    public FarmaciaModel(Long cnpj, int senha, String validaReceita) {
        this.cnpj = cnpj;
        this.senha = senha;
        this.validaReceita = validaReceita;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getValidaReceita() {
        return validaReceita;
    }

    public void setValidaReceita(String validaReceita) {
        this.validaReceita = validaReceita;
    }

    @Override
    public String toString() {
        return "FarmaciaModel{" +
                "cnpj=" + cnpj +
                ", senha=" + senha +
                ", validaReceita='" + validaReceita + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, senha, validaReceita);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarmaciaModel that = (FarmaciaModel) o;
        return senha == that.senha &&
                Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(validaReceita, that.validaReceita);
    }
}
