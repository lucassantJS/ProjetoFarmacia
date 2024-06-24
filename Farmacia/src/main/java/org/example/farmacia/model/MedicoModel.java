package org.example.farmacia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String crm;

    @Column(nullable = false)
    private String assinaturaDigital;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReceitaModel> receitas;

    public MedicoModel() {}


    public MedicoModel(String nome, String crm, String assinaturaDigital, List<ReceitaModel> receitas) {
        this.nome = nome;
        this.crm = crm;
        this.assinaturaDigital = assinaturaDigital;
        this.receitas = receitas;
    }


    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getAssinaturaDigital() {
        return assinaturaDigital;
    }

    public void setAssinaturaDigital(String assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    public List<ReceitaModel> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaModel> receitas) {
        this.receitas = receitas;
    }

    @Override
    public String toString() {
        return "MedicoModel{" +
                "idMedico=" + idMedico +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", assinaturaDigital='" + assinaturaDigital + '\'' +
                ", receitas=" + receitas +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedico, crm);
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoModel that = (MedicoModel) o;
        return Objects.equals(idMedico, that.idMedico) &&
                Objects.equals(crm, that.crm);
    }
}
