package Service.Impl;

import BeanFactory.BeanFactory;
import Dao.DinnertableDao;
import Entity.Dinnertable;
import Entity.TableStatus;
import Service.DinnertableService;

import java.util.List;

public class DinnertableServiceImpl implements DinnertableService {
    //调用的dao
    private DinnertableDao DinnerDao = BeanFactory.getInstance("DinnertableDao", DinnertableDao.class);


    @Override
    public List<Dinnertable> findByNoUse() {
        return DinnerDao.findByStatus(TableStatus.Free);
    }

    @Override
    public Dinnertable findById(int id) {
        return DinnerDao.findById(id);
    }
}
