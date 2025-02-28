package com.example.api_restful_spring.controllers;

import com.example.api_restful_spring.models.Producto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return ResponseEntity.ok(producto); // Devuelve el producto agregado
    }


    @GetMapping
    public Flux<Producto> listarProductos() {
        return Flux.fromIterable(productos);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Producto>> obtenerProducto(@PathVariable String id) {
        return Mono.justOrEmpty(productos.stream().filter(p -> p.getId().equals(id)).findFirst())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Producto>> actualizarProducto(@PathVariable String id, @RequestBody Producto producto) {
        return obtenerProducto(id).flatMap(p -> {
            p.getBody().setNombre(producto.getNombre());
            p.getBody().setPrecio(producto.getPrecio());
            return Mono.just(ResponseEntity.ok(p.getBody()));
        });
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminarProducto(@PathVariable String id) {
        productos.removeIf(p -> p.getId().equals(id));
        return Mono.just(ResponseEntity.ok().build());
    }
}
