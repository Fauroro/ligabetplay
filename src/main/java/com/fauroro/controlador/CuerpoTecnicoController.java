package com.fauroro.controlador;

import com.fauroro.abstraccion.Repositorio;
import com.fauroro.models.CuerpoTecnico;

import java.util.ArrayList;
import java.util.List;

public class CuerpoTecnicoController extends Repositorio<CuerpoTecnico> {

    List<CuerpoTecnico> ArrayCuerpoTecnico;

    public CuerpoTecnicoController() {
        this.ArrayCuerpoTecnico = new ArrayList<>();
    }

    @Override
    public void save(CuerpoTecnico objeto) {
        this.ArrayCuerpoTecnico.add(objeto);

    }

    @Override
    public List<CuerpoTecnico> show() {
        return ArrayCuerpoTecnico;
    }

    @Override
    public CuerpoTecnico searchId(int id) {
        CuerpoTecnico resultado = null;
        for (CuerpoTecnico c : ArrayCuerpoTecnico) {
            if (c.getId() == id) {
                resultado = c;
            }
        }
        return resultado;
    }

    @Override
    public int lastId() {
        return this.ArrayCuerpoTecnico.size() + 1;
    }

    @Override
    public List<CuerpoTecnico> load() {
        return null;
    }

    @Override
    public void savePersona() {

    }

    @Override
    public void update(CuerpoTecnico objeto) {

    }
}
