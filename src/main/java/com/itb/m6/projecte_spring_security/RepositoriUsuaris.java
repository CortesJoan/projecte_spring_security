package com.itb.m6.projecte_spring_security;

import com.itb.m6.projecte_spring_security.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari,Long> {
}
