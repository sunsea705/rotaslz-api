package com.rotaslzapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "linha")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Linha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    @NotNull
    private String numero;

    @Column(name = "descricao", nullable = false)
    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "prefixo_id")
    private Prefixo prefixo;

    public void atualizarInstancia(String numero, String descricao, Prefixo prefixo) {
        this.numero = numero != null ? numero : this.numero;
        this.descricao = descricao != null ? descricao : this.descricao;
        this.prefixo = prefixo != null ? prefixo : this.prefixo;
    }

    @Override
    public String toString() {
        String sigla = this.prefixo.getSigla() != null ? this.prefixo.getSigla() : "";
        return sigla + this.numero + " - " + this.descricao;
    }

}
