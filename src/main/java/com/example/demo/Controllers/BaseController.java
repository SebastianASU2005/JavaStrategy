package com.example.demo.Controllers;

import com.example.demo.Entities.Base;
import com.example.demo.Repositories.BaseRepository;
import com.example.demo.Service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
public abstract class BaseController <T extends Base, ID, Repo extends BaseRepository<T, ID>, Service extends BaseService<T, ID, Repo>> {
    protected final Service service;

    public BaseController(Service service) {this.service = service;}

    @GetMapping
    public ResponseEntity<?> findAll() {
        try{
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ID id) {
        try {
            T entity = service.findById(id);
            if (entity == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
