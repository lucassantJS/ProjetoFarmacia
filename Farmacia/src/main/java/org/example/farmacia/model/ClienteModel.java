package org.example.farmacia.model;

import jakarta.persistence.*;

import java.util.Date;

import java.util.Objects;

@Entity
@Table(name = "Cliente")
public class ClienteModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idCliente;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false, unique = true)
        private String cpf;

        @Column(nullable = false)
        @Temporal(TemporalType.DATE)
        private Date dataNascimento;

        @Column
        private double planoDeSaude;

        public ClienteModel() {}

        public ClienteModel(String nome, String cpf, Date dataNascimento, double planoDeSaude) {
                this.nome = nome;
                this.cpf = cpf;
                this.dataNascimento = dataNascimento;
                this.planoDeSaude = planoDeSaude;
        }

        public Long getIdCliente() {
                return idCliente;
        }

        public void setIdCliente(Long idCliente) {
                this.idCliente = idCliente;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public Date getDataNascimento() {
                return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
                this.dataNascimento = dataNascimento;
        }

        public double getPlanoDeSaude() {
                return planoDeSaude;
        }

        public void setPlanoDeSaude(double planoDeSaude) {
                this.planoDeSaude = planoDeSaude;
        }

        // Override toString method
        @Override
        public String toString() {
                return "ClienteModel{" +
                        "idCliente=" + idCliente +
                        ", nome='" + nome + '\'' +
                        ", cpf='" + cpf + '\'' +
                        ", dataNascimento=" + dataNascimento +
                        ", planoDeSaude=" + planoDeSaude +
                        '}';
        }

        // Override hashCode method
        @Override
        public int hashCode() {
                return Objects.hash(idCliente, cpf);
        }

        // Override equals method
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ClienteModel that = (ClienteModel) o;
                return Objects.equals(idCliente, that.idCliente) && Objects.equals(cpf, that.cpf);
        }
}
