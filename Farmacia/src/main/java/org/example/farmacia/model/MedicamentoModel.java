package org.example.farmacia.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Medicamento")
public class MedicamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(nullable = false)
    private String nomeMedicamento;

    @Column(nullable = false)
    private String dosagem;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private String viaAdmin;

    @Column
    private String observacao;

    public MedicamentoModel() {}

    public MedicamentoModel(String nomeMedicamento, String dosagem, Integer quantidade, String viaAdmin, String observacao) {
        this.nomeMedicamento = nomeMedicamento;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
        this.viaAdmin = viaAdmin;
        this.observacao = observacao;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getViaAdmin() {
        return viaAdmin;
    }

    public void setViaAdmin(String viaAdmin) {
        this.viaAdmin = viaAdmin;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "MedicamentoModel{" +
                "idMedicamento=" + idMedicamento +
                ", nomeMedicamento='" + nomeMedicamento + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", quantidade=" + quantidade +
                ", viaAdmin='" + viaAdmin + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicamento, nomeMedicamento, dosagem, quantidade, viaAdmin, observacao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicamentoModel that = (MedicamentoModel) o;
        return Objects.equals(idMedicamento, that.idMedicamento) &&
                Objects.equals(nomeMedicamento, that.nomeMedicamento) &&
                Objects.equals(dosagem, that.dosagem) &&
                Objects.equals(quantidade, that.quantidade) &&
                Objects.equals(viaAdmin, that.viaAdmin) &&
                Objects.equals(observacao, that.observacao);
    }
}
