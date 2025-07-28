package com.example.demo.Service;

import com.example.demo.Entities.Base;
import com.example.demo.Repositories.BaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class BaseService <T extends Base, ID, Repo extends BaseRepository<T,ID>> {
    @Autowired
    protected Repo baseRepository;

    public List<T> findAll() throws Exception {
        try{
            return baseRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public T findById(ID id) throws Exception {
        try{
            return baseRepository.findById(id).orElse(null);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public T save(T entity) throws Exception {
        try{
            return baseRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public T update(ID id, T entity) throws Exception {
        try{
            T entityToUpdate = baseRepository.findById(id)
                    .orElseThrow(() -> new Exception("Entity not Found"));

            BeanUtils.copyProperties(entity, entityToUpdate, "id");
            return baseRepository.saveAndFlush(entityToUpdate);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void delete(ID id) throws Exception {
        try {
            baseRepository.deleteById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
