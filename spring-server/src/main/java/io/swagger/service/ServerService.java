package io.swagger.service;

import io.swagger.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Server createServer(Server server) {
        return mongoTemplate.insert(server);
    }

    public List<Server> getAllServers() {
        return mongoTemplate.findAll(Server.class);
    }

    public Optional<Server> getServerById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Server server = mongoTemplate.findOne(query, Server.class);
        return Optional.ofNullable(server);
    }

    public Server updateServer(Server updatedServer) {
        Optional<Server> existingServer = getServerById(updatedServer.getId());

        if (existingServer.isPresent()) {
            Server serverToUpdate = existingServer.get();
            serverToUpdate.setName(updatedServer.getName());
            serverToUpdate.setLanguage(updatedServer.getLanguage());
            serverToUpdate.setFramework(updatedServer.getFramework());
            return mongoTemplate.save(serverToUpdate);
        } else {
            throw new RuntimeException("Server not found");
        }
    }

    public void deleteServer(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Server.class);
    }

    public void deleteAllServers() {
        mongoTemplate.remove(new Query(), Server.class);
    }

    public List<Server> findServersByName(String name) {
        Query query = new Query(Criteria.where("name").regex(name, "i"));
        return mongoTemplate.find(query, Server.class);
    }
}
