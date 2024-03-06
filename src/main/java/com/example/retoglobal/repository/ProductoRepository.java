package com.example.retoglobal.repository;

import com.example.retoglobal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByFechaRegistroBetween(Date fechaInicio, Date fechaFin);
}

