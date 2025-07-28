package com.example.demo.Controllers;

import com.example.demo.Entities.Director;
import com.example.demo.Repositories.DirectorRepository;
import com.example.demo.Service.DirectorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strategy/director")
public class DirectorController extends BaseController<Director, Long, DirectorRepository, DirectorService> {
    public DirectorController(DirectorService directorService) {
        super(directorService);
    }
}
