package Dao;

import model.FoundStructure;

import java.util.List;

public abstract class AbstractDAO <T> {
    public abstract T getById(int id);
    public abstract List<T> getAll();
    public abstract void add(T t);
    public abstract void remove(T t);
}
