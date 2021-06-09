package com.itb.m6.projecte_spring_security;

import com.itb.m6.projecte_spring_security.model.Manga;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriManga extends CrudRepository<Manga, Long> {

}
