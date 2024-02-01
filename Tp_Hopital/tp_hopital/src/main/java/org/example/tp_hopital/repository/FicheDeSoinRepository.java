package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.FicheDeSoin;

import java.util.List;

public class FicheDeSoinRepository extends Repository<FicheDeSoin> {
    @Override
    public FicheDeSoin findById(int id) {
        return session.get(FicheDeSoin.class,id);
    }

    @Override
    public List<FicheDeSoin> findAll() {
        return session.createQuery( "from FicheDeSoin").list();
    }



}
