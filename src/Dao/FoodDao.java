package Dao;

import Entity.Food;
import Utils.PageBean;

import java.util.List;

public interface FoodDao {

    //分页按条件查所有菜品
    void getAll(PageBean<Food> pb);

    //按条件统计菜的总记录数
    int getTotal(PageBean<Food> pb);

    //根据id查
    Food findById(int id);

}
