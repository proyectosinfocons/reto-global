package com.example.retoglobal.service;

import com.example.retoglobal.entity.Producto;
import com.example.retoglobal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EjemploProcedureService ejemploProcedureService;

    public void insertarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Producto> obtenerProductosRegistradosHoy() {
        return ejemploProcedureService.obtenerProductosRegistradosHoy();
    }
}
