package com.rotaslzapi.models;

import com.rotaslzapi.enums.Sentido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "localidade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sentido", nullable = false)
    @NotNull
    private Sentido sentido;

    @Column(name = "descricao", nullable = false)
    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_localidade_id")
    private TipoLocalidade tipoLocalidade;

}
