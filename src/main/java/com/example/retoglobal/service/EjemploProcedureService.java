package com.example.retoglobal.service;

import com.example.retoglobal.entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EjemploProcedureService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> obtenerProductosRegistradosHoy() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_ejemplo")
                .registerStoredProcedureParameter("id", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("fec_registro", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("cursor", void.class, ParameterMode.REF_CURSOR)
                .registerStoredProcedureParameter("código", Integer.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("mensaje", String.class, ParameterMode.OUT)
                .setParameter("id", null)
                .setParameter("nombre", null)
                .setParameter("fec_registro", new Date());

        query.execute();

        Integer codigo = (Integer) query.getOutputParameterValue("código");
        String mensaje = (String) query.getOutputParameterValue("mensaje");

        // Manejar código y mensaje según sea necesario

        List<Object[]> resultados = query.getResultList();
        List<Producto> productos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Producto producto = new Producto();
            producto.setId((Long) resultado[0]); // Suponiendo que el ID es el primer elemento del resultado
            producto.setNombre((String) resultado[1]); // Suponiendo que el nombre es el segundo elemento del resultado
            producto.setFechaRegistro((Date) resultado[2]); // Suponiendo que la fecha de registro es el tercer elemento del resultado
            productos.add(producto);
        }

        return productos;
    }
}

