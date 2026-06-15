package br.edu.unicesumar.builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final int numeroTicket;
    private final String titulo;
    private final String descricao;
    private final String emailSolicitante;

    private final String departamento;
    private final String versaoSistema;
    private final List<String> anexos;
    private final boolean urgente;

    private final LocalDateTime abertura;

    private Ticket(Builder b){
        this.numeroTicket = b.numeroTicket;
        this.titulo = b.titulo;
        this.descricao = b.descricao;
        this.emailSolicitante = b.emailSolicitante;
        this.departamento = b.departamento;
        this.versaoSistema = b.versaoSistema;
        this.anexos = b.anexos;
        this.urgente = b.urgente;

        this.abertura = LocalDateTime.now();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getVersaoSistema() {
        return versaoSistema;
    }

    public List<String> getAnexos() {
        return anexos;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numeroTicket=" + numeroTicket +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", emailSolicitante='" + emailSolicitante + '\'' +
                ", departamento='" + departamento + '\'' +
                ", versaoSistema='" + versaoSistema + '\'' +
                ", anexos=" + anexos +
                ", urgente=" + urgente +
                '}';
    }

    public static class Builder {
        private int numeroTicket;
        private String titulo;
        private String descricao;
        private String emailSolicitante;

        private String departamento = "Geral";
        private String versaoSistema = "Não informada";
        private List<String> anexos = new ArrayList<>();
        private boolean urgente = false;

        public Builder(int numeroTicket, String titulo, String descricao, String emailSolicitante) {
            this.numeroTicket = numeroTicket;
            this.titulo = titulo;
            this.descricao = descricao;
            this.emailSolicitante = emailSolicitante;
        }

        public Builder departamento(String departamento){
            this.departamento = departamento;
            return this;
        }

        public Builder versaoSistema(String versaoSistema){
            this.versaoSistema = versaoSistema;
            return this;
        }

        public Builder anexos(List<String> anexos){
            this.anexos = anexos;
            return this;
        }

        public Builder urgente(boolean urgente){
            this.urgente = urgente;
            return this;
        }

        public Ticket build(){
            if (this.titulo == null || this.titulo.isBlank()) throw new RuntimeException("Titulo invalido");
            if (this.emailSolicitante == null || this.emailSolicitante.isBlank() || !this.emailSolicitante.contains("@")) throw new RuntimeException("E-mail inválido");
            if (this.descricao == null || this.descricao.isBlank() ) throw new RuntimeException("Descrição inválida");
            if (this.numeroTicket <= 0) throw new RuntimeException("Valor do ticket não pode ser menor que 1");

            return new Ticket(this);
        }
    }

}
