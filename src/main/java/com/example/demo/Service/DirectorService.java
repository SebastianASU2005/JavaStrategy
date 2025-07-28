package com.example.demo.Service;

import com.example.demo.Entities.Director;
import com.example.demo.Repositories.DirectorRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService extends BaseService<Director, Long, DirectorRepository> {
}
