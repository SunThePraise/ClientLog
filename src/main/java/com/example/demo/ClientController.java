package com.example.demo;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @GetMapping("/clients")
    public List<Client> getAllClients (ClientRepo repo){
        return repo.findAll();
    }
    @GetMapping("/clients/{name}")
    public Client getClient (ClientRepo repo, @PathVariable String name){
        return repo.getReferenceById(name);
    }

    @PostMapping("/clients/{name}")
    public Client createClient(@RequestBody Client newClient, ClientRepo repo){
        return repo.save(newClient);
    }
    //this might not work, I chose not to use a stream like the tutorial did
    @PutMapping("/clients/{name}")
    public Client replaceClient(ClientRepo repo, @RequestBody Client newClient, @PathVariable String name){
        Client temp = repo.getReferenceById(name);
        temp.setName(newClient.getName());
        temp.setAge(newClient.getAge());
        temp.setStatus(newClient.getStatus());

        return repo.save(temp);

    }

    //This might not work, would have to test
    @PutMapping("/clients/{name}")
    public Client changeClientStatus(ClientRepo repo, @RequestBody Client updatedClient, @PathVariable String name){
        Client temp = repo.getReferenceById(name);
        if (Objects.equals(temp.getStatus(), "Active")){
            temp.setStatus("Inactive");
        }
        if (Objects.equals(temp.getStatus(), "Inactive")){
            temp.setStatus("Active");
        }
        return repo.save(temp);
    }
    public void deleteClient (ClientRepo repo, @PathVariable String name){
        repo.deleteById(name);
    }

}
