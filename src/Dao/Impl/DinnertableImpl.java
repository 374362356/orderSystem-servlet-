package Dao.Impl;

import Dao.DinnertableDao;
import Entity.Dinnertable;
import Entity.TableStatus;
import Utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class DinnertableImpl implements DinnertableDao {
    @Override
    public List<Dinnertable> findByStatus(TableStatus ts) {
        String sql="select * from dinnertable where tableStatus=?";
        /*int status=-1;
        if(ts == TableStatus.Free){
            status=0;
        }else {
            status=1;
        }*/

        try {
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<Dinnertable>(Dinnertable.class),ts.ordinal());//枚举值下标
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Dinnertable findById(int id) {
        String sql="select * from dinnertable where id=?";
        try {
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<Dinnertable>(Dinnertable.class),id);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
}
