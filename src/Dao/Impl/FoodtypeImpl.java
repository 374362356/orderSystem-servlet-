package Dao.Impl;

import Dao.FoodtypeDao;
import Entity.Foodtype;
import Utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class FoodtypeImpl implements FoodtypeDao {
    @Override
    public void save(Foodtype foodtype) {
        String sql="insert into foodtype(typeName) values(?)";

        try {
            JdbcUtils.getQueryRunner().update(sql,foodtype.getTypeName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Foodtype foodtype) {
        String sql="update foodtype set typeName=? where id=?";

        try {
            JdbcUtils.getQueryRunner().update(sql,foodtype.getTypeName(),foodtype.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql="delete from foodtype where id=?";

        try {
            JdbcUtils.getQueryRunner().update(sql,id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Foodtype findByid(int id) {
        String sql="select * from foodtype where id=?";

        try {
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<Foodtype>(Foodtype.class),id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Foodtype> findAll() {
        String sql="select * from foodtype";

        try {
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<Foodtype>(Foodtype.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    @Override
    public List<Foodtype> getByName(String typeName) {
        String sql="select * from foodtype where typeName like ?";

        try {
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<Foodtype>(Foodtype.class),"%"+typeName+"%");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
