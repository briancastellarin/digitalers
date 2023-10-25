package com.digitalers.academia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.digitalers.academia.entity.Entidad;

@NoRepositoryBean
public interface Repositorio<T extends Entidad, N extends Serializable> extends JpaRepository<T, N> {
}
