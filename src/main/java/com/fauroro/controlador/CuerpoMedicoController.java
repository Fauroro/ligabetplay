package com.fauroro.controlador;

import com.fauroro.abstraccion.Repositorio;
import com.fauroro.models.CuerpoMedico;

import java.util.ArrayList;
import java.util.List;

public class CuerpoMedicoController extends Repositorio<CuerpoMedico> {

    List<CuerpoMedico> ArrayCuerpoMedico;

    public CuerpoMedicoController() {
        this.ArrayCuerpoMedico = new ArrayList<>();
    }

    @Override
    public void save(CuerpoMedico objeto) {
        this.ArrayCuerpoMedico.add(objeto);

    }

    @Override
    public List<CuerpoMedico> show() {
        return ArrayCuerpoMedico;
    }

    @Override
    public CuerpoMedico searchId(int id) {
        CuerpoMedico resultado = null;
        for (CuerpoMedico c : ArrayCuerpoMedico) {
            if (c.getId() == id) {
                resultado = c;
            }
        }
        return resultado;
    }

    @Override
    public int lastId() {
        return this.ArrayCuerpoMedico.size() + 1;
    }

    @Override
    public List<CuerpoMedico> load() {
        return null;
    }

    @Override
    public void savePersona() {

    }

    @Override
    public void update(CuerpoMedico objeto) {

    }
}
