package Service.Impl;

import BeanFactory.BeanFactory;
import Dao.FoodDao;
import Entity.Food;
import Service.FoodService;
import Utils.PageBean;

public class FoodServiceImpl implements FoodService {
    //创建dao
    private FoodDao foodDao = BeanFactory.getInstance("FoodDao", FoodDao.class);

    @Override
    public Food findById(int id) {
        return foodDao.findById(id);
    }

    @Override
    public void getAll(PageBean<Food> pb) {
         foodDao.getAll(pb);
    }
}
