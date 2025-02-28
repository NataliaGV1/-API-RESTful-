package com.example.api_restful_spring;

import com.example.api_restful_spring.controllers.ProductoController;
import com.example.api_restful_spring.models.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductoControllerTest {

    @Autowired
    private ProductoController productoController;

    @Test
    public void testListaProductos() {
        // Agregamos productos de prueba
        productoController.agregarProducto(new Producto("1", "Laptop", 1000.0));
        productoController.agregarProducto(new Producto("2", "Mouse", 50.0));
        productoController.agregarProducto(new Producto("3", "Teclado", 75.0));

        Flux<Producto> productos = productoController.listarProductos();

        StepVerifier.create(productos)
                .expectNextMatches(p -> p.getNombre().equals("Laptop"))
                .expectNextMatches(p -> p.getNombre().equals("Mouse"))
                .expectNextMatches(p -> p.getNombre().equals("Teclado"))
                .verifyComplete();
    }
}
