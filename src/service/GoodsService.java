package service;

import Dao.GoodsDao;
import model.Goods;
import model.Page;
import model.Type;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsService {
    private GoodsDao gDao = new GoodsDao();

    public Page getGoodsList(int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 9;
        int totalCount = 0;
        try {
            totalCount = gDao.selectGoodsCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        List list = null;
        try {
            list = gDao.selectGoodsList(pageNumber, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    //查询的分页数据
    public Page getGoodsList(int pageNumber,String goodsName) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 9;
        int totalCount = 0;
        try {
            totalCount = gDao.selectGoodsCount(goodsName);
            System.out.println("count:"+ gDao.selectGoodsCount(goodsName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        List list = null;
        try {
            list = gDao.selectGoodsList(pageNumber, pageSize,goodsName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Goods getGoodsById(int id) {
        Goods g = null;
        try {
            g = gDao.getGoodsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return g;
    }

    //获取类型列表
    public List<Type> getTypeList() {
        List<Type> list = null;
        try {
            list = gDao.getTypeList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //增加商品函数
    public void addGoods(Goods goods) {
        try {
            gDao.addGoods(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //删除goods
    public void delete(int id) {
        try {
            gDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGoods(Goods g) {
        try{
            gDao.updateGoods(g);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
