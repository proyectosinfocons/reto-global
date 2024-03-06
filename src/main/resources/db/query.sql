CREATE TABLE productos (
                           id NUMBER PRIMARY KEY,
                           nombre VARCHAR2(100),
                           fec_registro DATE
);


CREATE OR REPLACE PROCEDURE sp_ejemplo (
    id_input IN NUMBER,
    nombre_input IN VARCHAR2,
    fec_registro_input IN DATE,
    cursor_output OUT SYS_REFCURSOR,
    codigo_output OUT INTEGER,
    mensaje_output OUT VARCHAR2
)
AS
BEGIN
    -- Insertar el producto utilizando los parámetros de entrada
INSERT INTO productos (id, nombre, fec_registro)
VALUES (id_input, nombre_input, fec_registro_input);

-- Abrir el cursor para devolver la lista de productos registrados en el día
OPEN cursor_output FOR
SELECT * FROM productos WHERE TRUNC(fec_registro) = TRUNC(SYSDATE);

-- Establecer valores para los parámetros de salida
codigo_output := 0;
    mensaje_output := 'Éxito';
EXCEPTION
    WHEN OTHERS THEN
        -- En caso de error, establecer valores para los parámetros de salida
        codigo_output := SQLCODE;
        mensaje_output := SQLERRM;
END sp_ejemplo;
/
