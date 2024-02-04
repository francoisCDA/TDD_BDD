package org.cda.tp_devinettes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity(name="devinette")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Devinette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_riddle", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    private String riddle;

    private String answer;

    @OneToMany(mappedBy = "devinette", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Reponse> reponses = new ArrayList<>();


}
