package com.rotaslzapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "linha_localidade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinhaLocalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linha_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Linha linha;

    @ManyToOne
    @JoinColumn(name = "localidade_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Localidade localidade;

    @Column(name = "ordem", nullable = false)
    @NotNull
    private Integer ordem;

}
