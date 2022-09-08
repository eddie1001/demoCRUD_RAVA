package com.angelramirez.demoCRUD.controllers;

import com.angelramirez.demoCRUD.dto.ApiResponse;
import com.angelramirez.demoCRUD.model.ClienteModel;
import com.angelramirez.demoCRUD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ApiResponse getAllClientes () {
        try {
            return new ApiResponse(HttpStatus.OK.value(), "Lista de Clientes", clienteService.findAll());
        } catch (Exception ex) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al listar los clientes", false);
        }
    }

    @GetMapping("{id}")
    public ApiResponse getCliente (@PathVariable Long id){
        try {
            return new ApiResponse(HttpStatus.OK.value(), "Cliente Obtenido", clienteService.findById(id));
        } catch (Exception ex) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al obtener cliente", false);
        }
    }

    @PostMapping
    public ApiResponse addCliente (@RequestBody ClienteModel client) {
        try {
            return new ApiResponse(HttpStatus.OK.value(), "Cliente Agregado", clienteService.add(client));
        } catch (Exception ex) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar Cliente", false);
        }
    }

    @PutMapping("{id}")
    public ApiResponse updateCliente (@PathVariable Long id, @RequestBody ClienteModel client){
        try {
            return new ApiResponse(HttpStatus.OK.value(), "Cliente Actualizado", clienteService.update(id, client));
        } catch (Exception ex) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar Cliente", false);
        }
    }


    @DeleteMapping("{id}")
    public ApiResponse deleteCliente (@PathVariable Long id){
        try {
            clienteService.delete(id);
            return new ApiResponse(HttpStatus.OK.value(), "Cliente Eliminado", true);
        } catch (Exception ex) {
            return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al eliminar Cliente", false);
        }
    }

}
