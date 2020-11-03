package Service;

import Entity.Food;
import Utils.PageBean;

public interface FoodService {

    Food findById(int id);

    void getAll(PageBean<Food> pb);
}
