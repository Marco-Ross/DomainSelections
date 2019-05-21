package com.marco.repository;

public interface RepositoryGI<T, ID>{
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(ID id);
}
