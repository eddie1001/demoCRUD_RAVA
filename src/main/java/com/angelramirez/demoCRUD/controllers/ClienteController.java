package com.angelramirez.demoCRUD.controllers;

import com.angelramirez.demoCRUD.model.ClienteModel;
import com.angelramirez.demoCRUD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Configuration
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> getAllClientes () {
        try {
            return clienteService.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @GetMapping("{id}")
    public ClienteModel getCliente (@PathVariable Long id){
        try {
            return clienteService.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public ClienteModel addCliente (@RequestBody ClienteModel client) {
        try {
            return clienteService.add(client);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @PutMapping("{id}")
    public ClienteModel updateCliente (@PathVariable Long id, @RequestBody ClienteModel client){
        try {
            return clienteService.update(id, client);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @DeleteMapping("{id}")
    public String deleteCliente (@PathVariable Long id){
        try {
            clienteService.delete(id);
            return "Cliente Eliminado";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
