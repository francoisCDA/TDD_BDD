package org.example.tp_hopital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FicheDeSoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="type_de_soin")
    private String typeSoin;

    @Column(name="nb_jour")
    private int nbjour;


    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

}
