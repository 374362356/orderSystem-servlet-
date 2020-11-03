package Dao;

import Entity.Dinnertable;
import Entity.TableStatus;

import java.util.List;

public interface DinnertableDao {

    List<Dinnertable> findByStatus(TableStatus ts);    //查询所有未预定餐桌

    Dinnertable findById(int id);     //主键查询
}
