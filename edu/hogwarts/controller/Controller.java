package edu.hogwarts.controller;

import java.util.*;

public abstract class Controller<T> {

    public abstract void add(T entity);

    public abstract void add(T[] entities);

    public abstract T get(UUID id);

    public abstract ArrayList<T> getAll();

    public abstract void update(UUID id, T entity);

    public abstract void delete(UUID id);
}