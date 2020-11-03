package Dao;

import Entity.Foodtype;

import java.util.List;

public interface FoodtypeDao {

    void save(Foodtype foodtype);

    void update(Foodtype foodtype);

    void delete(int id);

    Foodtype findByid(int id);

    List<Foodtype> findAll();

    List<Foodtype> getByName(String typeName);

}
