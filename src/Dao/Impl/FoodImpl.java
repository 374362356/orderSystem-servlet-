package Dao.Impl;

import Dao.FoodDao;
import Entity.Food;
import Utils.Condition;
import Utils.JdbcUtils;
import Utils.PageBean;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodImpl implements FoodDao {

    @Override
    public void getAll(PageBean<Food> pb) {
       //获取条件对象
        Condition cond = pb.getCondition();
        //条件之类别id
        int typeId = cond.getFoodType_id();
        //条件之菜名
        String foodName = cond.getFoodName();

        StringBuffer sb = new StringBuffer();
        sb.append(" select");
        sb.append(" f.id,");
        sb.append(" f.foodName,");
        sb.append(" f.foodType_id,");
        sb.append(" f.price,");
        sb.append(" f.memberprice,");
        sb.append(" f.introduce,");
        sb.append(" f.img,");
        sb.append(" t.typeName");
        sb.append(" from");
        sb.append(" food f,");
        sb.append(" foodtype t");
        sb.append(" where 1=1 ");
        sb.append(" and f.foodType_id=t.id");

        //存储条件查询对应的值
        List<Object> list = new ArrayList<Object>();

        //拼接条件查询
        if(typeId>0){
            sb.append(" and f.foodType_id=?");
            list.add(typeId);
        }
        if(foodName!=null && !"".equals(foodName.trim())){
            sb.append(" and f.foodName like ?");
            list.add(foodName);
        }


        //分页条件
        sb.append(" limit ?,?");

        //判断：当前页<1，设置当前页为1；当当前页>总页数，设置当前页为总页数
        int totalCount = getTotal(pb);
        //设置分页bean参数的总记录数
        pb.setTotalCount(totalCount);

        if(pb.getCurrentPage()<1){
            pb.setCurrentPage(1);
        }else if(pb.getCurrentPage()>pb.getTotalPage()){
            pb.setCurrentPage(pb.getTotalPage());
        }

        //起始行
       int index = (pb.getCurrentPage()-1)*pb.getPageCount();
        //返回记录数
        int count = pb.getPageCount();
        list.add(index);
        list.add(count);

        try {
            List<Food> pageDate = JdbcUtils.getQueryRunner().query(sb.toString(),new BeanListHandler<Food>(Food.class),list.toArray());
            //把查询的数据放到分页对象中
            pb.setPageDate(pageDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getTotal(PageBean<Food> pb) {
        //获取条件对象
        Condition cond = pb.getCondition();
        //条件之类别id
        int typeId = cond.getFoodType_id();
        //条件之菜名
        String foodName = cond.getFoodName();

        StringBuffer sb = new StringBuffer();
        sb.append(" select");
        sb.append(" count(*)");
        sb.append(" from");
        sb.append(" food f,");
        sb.append(" foodtype t");
        sb.append(" where 1=1 ");
        sb.append(" and f.foodType_id=t.id");

        //存储条件查询对应的值
        List<Object> list = new ArrayList<Object>();

        //拼接条件查询
        if(typeId>0){
            sb.append(" and f.foodType_id=?");
            list.add(typeId);
        }
        if(foodName!=null && !"".equals(foodName.trim())){
            sb.append(" and f.foodName like ?");
            list.add(foodName);
        }

        try {
            Long num = JdbcUtils.getQueryRunner().query(sb.toString(),new ScalarHandler<Long>(),list.toArray());
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Food findById(int id) {

        StringBuffer sb = new StringBuffer();
        sb.append(" select");
        sb.append(" f.id,");
        sb.append(" f.foodName,");
        sb.append(" f.foodType_id,");
        sb.append(" f.price,");
        sb.append(" f.memberprice,");
        sb.append(" f.introduce,");
        sb.append(" f.img,");
        sb.append(" t.typeName");
        sb.append(" from");
        sb.append(" food f,");
        sb.append(" foodtype t");
        sb.append(" where 1=1 ");
        sb.append(" and f.foodType_id=t.id");

        try {
            return JdbcUtils.getQueryRunner().query(sb.toString(),new BeanHandler<Food>(Food.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
