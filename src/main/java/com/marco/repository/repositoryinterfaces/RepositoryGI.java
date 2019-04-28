package com.marco.repository.repositoryinterfaces;

public interface RepositoryGI<T, ID>{
    T create(T t);
    T update(T t);
    void delete(T t);
    T read(ID id);
}
