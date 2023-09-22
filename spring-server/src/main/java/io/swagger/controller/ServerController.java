package io.swagger.controller;

import io.swagger.annotations.*;
import io.swagger.model.Server;
import io.swagger.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/servers")
@Api(tags = "Server Management", description = "Endpoints for managing servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @ApiOperation(value = "Create a new server")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Server created successfully"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server savedServer = serverService.createServer(server);
        return new ResponseEntity<>(savedServer, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all servers")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get a server by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Server not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getServerById(
            @ApiParam(value = "Server ID", required = true) @PathVariable String id) {
        Optional<Server> server = serverService.getServerById(id);

        if (server.isPresent()) {
            return new ResponseEntity<>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Server not found", HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Update a server by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Server not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Server> updateServer(
            @ApiParam(value = "Server ID", required = true) @PathVariable String id,
            @RequestBody Server updatedServer) {
        Optional<Server> existingServer = serverService.getServerById(id);

        if (existingServer.isPresent()) {
            Server serverToUpdate = existingServer.get();
            serverToUpdate.setName(updatedServer.getName());
            serverToUpdate.setLanguage(updatedServer.getLanguage());
            serverToUpdate.setFramework(updatedServer.getFramework());

            Server savedServer = serverService.updateServer(serverToUpdate);
            return new ResponseEntity<>(savedServer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Delete a server by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Server not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(
            @ApiParam(value = "Server ID", required = true) @PathVariable String id) {
        serverService.deleteServer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Delete all servers")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content")
    })
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllServers() {
        serverService.deleteAllServers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Find servers by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    @GetMapping("/findByName")
    public ResponseEntity<List<Server>> findServersByName(
            @ApiParam(value = "Name to search for", required = true) @RequestParam String name) {
        List<Server> servers = serverService.findServersByName(name);
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }
}
