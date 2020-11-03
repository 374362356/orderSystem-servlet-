package Service;

import Entity.Foodtype;

import java.util.List;

public interface FoodtypeService {
    void save(Foodtype foodtype);

    void update(Foodtype foodtype);

    void delete(int id);

    Foodtype findByid(int id);

    List<Foodtype> findAll();

    List<Foodtype> getByName(String typeName);
}
