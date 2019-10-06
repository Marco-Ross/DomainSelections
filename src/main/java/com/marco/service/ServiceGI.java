package com.marco.service;

public interface ServiceGI<T, ID, R> {
    T create(T type);
    T update(T type);
    void delete(ID id);
    R read(ID id);
}
