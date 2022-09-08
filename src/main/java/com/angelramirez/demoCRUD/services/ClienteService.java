package com.angelramirez.demoCRUD.services;

import com.angelramirez.demoCRUD.model.ClienteModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ClienteService {

    public ArrayList<ClienteModel> findAll() throws Exception;

    public ClienteModel findById(Long id) throws Exception;

    public ClienteModel add(ClienteModel clienteModel) throws Exception;

    public void delete(Long id) throws Exception;

    public ClienteModel update(Long id, ClienteModel clienteModel) throws Exception;
}
