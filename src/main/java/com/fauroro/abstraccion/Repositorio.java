package com.fauroro.abstraccion;

import java.util.ArrayList;
import java.util.List;

abstract public class Repositorio<T> {

    abstract public void save(T jugador);
    abstract public List<T> show();
    abstract public T searchId(int id);
    abstract public int lastId();
    abstract public List<T> load();
    abstract public void savePersona();
    abstract public void update(T objeto);

}
