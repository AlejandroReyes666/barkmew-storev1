package com.barkmew.store.persistence;

import com.barkmew.store.domain.Purchase;
import com.barkmew.store.domain.repository.PurchaseRepository;
import com.barkmew.store.persistence.crud.CompraCrudRepository;
import com.barkmew.store.persistence.entity.Compra;
import com.barkmew.store.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientid) {
        return compraCrudRepository.findByIdCliente(clientid).map(compras -> mapper.toPurchases(compras) );
    }
    /* hay que revisar este metodo en la en purshasemapper se tiene compra en vez de
    * producto esto es debico a las relaciones en las entidades*/
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));

    }
}
