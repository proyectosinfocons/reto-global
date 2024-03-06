package com.example.retoglobal.controller;

import com.example.retoglobal.entity.Producto;
import com.example.retoglobal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<List<Producto>> insertarProducto(@RequestBody Producto producto) {
        productoService.insertarProducto(producto);
        List<Producto> productosRegistradosHoy = productoService.obtenerProductosRegistradosHoy();
        return ResponseEntity.ok(productosRegistradosHoy);
    }
}

