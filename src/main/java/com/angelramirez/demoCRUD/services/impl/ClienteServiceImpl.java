package com.angelramirez.demoCRUD.services.impl;

import com.angelramirez.demoCRUD.model.ClienteModel;
import com.angelramirez.demoCRUD.repositories.ClienteRepository;
import com.angelramirez.demoCRUD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ArrayList<ClienteModel> findAll() throws Exception {
        return (ArrayList<ClienteModel>) clienteRepository.getAll();
    }

    @Override
    public ClienteModel findById(Long id) throws Exception {
        return clienteRepository.getById(id);
    }

    @Override
    public ClienteModel add(ClienteModel clienteModel) throws Exception {
        return clienteRepository.add(clienteModel);
    }

    @Override
    public void delete(Long id) throws Exception {
        clienteRepository.delete(id);
    }

    @Override
    public ClienteModel update(Long id, ClienteModel clienteModel) throws Exception {
        return clienteRepository.update(id, clienteModel);
    }
}
