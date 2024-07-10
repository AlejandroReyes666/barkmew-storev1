package com.barkmew.store.persistence.crud;

import com.barkmew.store.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>>findByIdCliente (String idCliente);
}
