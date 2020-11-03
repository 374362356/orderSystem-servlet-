package Service.Impl;

import BeanFactory.BeanFactory;
import Dao.FoodtypeDao;
import Dao.Impl.FoodtypeImpl;
import Entity.Foodtype;
import Service.FoodtypeService;

import java.util.List;

public class FoodtypeServiceImpl implements FoodtypeService {

    //private FoodtypeDao typeDao = new FoodtypeImpl();
    //工厂创建
    private FoodtypeDao typeDao = BeanFactory.getInstance("typeDao",FoodtypeDao.class);

    @Override
    public void save(Foodtype foodtype) {
        typeDao.save(foodtype);
    }

    @Override
    public void update(Foodtype foodtype) {
        typeDao.update(foodtype);
    }

    @Override
    public void delete(int id) {
        typeDao.delete(id);
    }

    @Override
    public Foodtype findByid(int id) {
        return typeDao.findByid(id);
    }

    @Override
    public List<Foodtype> findAll() {
        return typeDao.findAll();
    }

    @Override
    public List<Foodtype> getByName(String typeName) {
        return typeDao.getByName(typeName);
    }
}
