package org.cda.tp_devinettes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity(name="reponse")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reponse", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name="user_answer")
    private String userAnswer;


    @ManyToOne
    @JoinColumn(name = "devinette_id")
    private Devinette devinette;

}
