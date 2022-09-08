package com.angelramirez.demoCRUD.repositories;

import com.angelramirez.demoCRUD.model.ClienteModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class ClienteRepository{

    private static List<ClienteModel> clienteModelList = new ArrayList<>();

    private void conectarData(){
        try {
            Path filepath = Path.of("data.json");
            clienteModelList = new ArrayList(Arrays.asList(new Gson().fromJson(Files.readString(filepath), ClienteModel[].class)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void actualizarData(){
        try {
            Path filepath = Path.of("data.json");
            Files.write(filepath, new Gson().toJson(clienteModelList).getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<ClienteModel> getAll() throws Exception {
        try {
            conectarData();
            return clienteModelList;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public ClienteModel getById(Long id) throws Exception {
        try {
            conectarData();
            if (clienteModelList.isEmpty() || !clienteModelList.stream().anyMatch(clientModel -> clientModel.getId().equals(id)))
                throw new Exception("No se encontró al cliente");
            return clienteModelList.stream().filter(c -> c.getId().equals(id)).findFirst().get();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    public ClienteModel add(ClienteModel clienteModel) throws Exception{
        try {
            conectarData();
            Long idCliente = clienteModelList.isEmpty() ? 1l : clienteModelList.stream().max(Comparator.comparing(c -> c.getId())).get().getId() + 1;
            clienteModel.setId(idCliente);
            clienteModelList.add(clienteModel);
            actualizarData();
            return clienteModel;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean delete(Long id) throws Exception {
        try {
            conectarData();
            deleteFromList(id);
            actualizarData();
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private void deleteFromList(Long id) throws Exception {
        try {
            conectarData();
            clienteModelList.removeIf(c -> c.getId().equals(id));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public ClienteModel update(Long id, ClienteModel clienteModel) throws Exception {
        try {
            conectarData();
            deleteFromList(id);
            clienteModel.setId(id);
            clienteModelList.add(clienteModel);
            actualizarData();
            return clienteModel;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
