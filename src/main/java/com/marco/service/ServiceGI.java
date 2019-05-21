package com.marco.service;

public interface ServiceGI<T, ID> {
    T create(T type);
    T update(T type);
    void delete(ID id);
    T read(ID id);
}
