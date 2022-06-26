package Dao;

import model.Goods;
import model.Type;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsDao {
    //获取商品总条数
    public int selectGoodsCount() throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from goods";
        return r.query(sql,new ScalarHandler<Long>()).intValue();
    }
    //获取分页商品
    public List selectGoodsList(int pageNumber, int pageSize) throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods limit ?,?";
        return r.query(sql,new BeanListHandler<Goods>(Goods.class),(pageNumber-1)*pageSize,pageSize);
    }

    //获取搜索的商品
    public int selectGoodsCount(String goodsName) throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from goods where name like ?";
        return r.query(sql,new ScalarHandler<Long>(),"%"+goodsName+"%").intValue();
    }
    //获取搜索的分页商品
    public List selectGoodsList(int pageNumber, int pageSize,String goodsName) throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods where name like ? limit ?,?";
        return r.query(sql,new BeanListHandler<Goods>(Goods.class),"%"+goodsName+"%",(pageNumber-1)*pageSize,pageSize);
    }
    //index分类的形式获取商品
//    public List<Map<String,Object>> getGoodsList(int recommendType) throws SQLException {
//        //获取连接对象
//        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
//        String sql = "select g.id,g.name,g.cover,g.price,t.name typename " +
//                "from recommend r,goods g,type t where type=? and r.goods_id = g.id and g.type_id=t.id";
//        return r.query(sql,new MapListHandler(),recommendType);
//    }

    public Goods getGoodsById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id = t.id";
        return r.query(sql,new BeanHandler<Goods>(Goods.class),id);
    }

    //获取类型列表
    public List<Type> getTypeList() throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type";
        return r.query(sql,new BeanListHandler<Type>(Type.class));
    }
    //增加商品方法
    public void addGoods(Goods goods) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into goods(name,cover,image1,image2,price,intro,stock,type_id)"+
                "value(?,?,?,?,?,?,?,?)";
        r.update(sql,goods.getName(),goods.getCover(),goods.getImage1(),goods.getImage2(),goods.getPrice(),goods.getIntro(),goods.getStock(),goods.getType_id());
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from goods where id = ?";
        r.update(sql,id);
    }

    public void updateGoods(Goods g) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update goods set name=?,cover=?,image1=?,image2=?,price=?,intro=?,stock=?,type_id=? where id = ?";
        r.update(sql,g.getName(),g.getCover(),g.getImage1(),g.getImage2(), g.getPrice(),g.getIntro(), g.getStock(),g.getType_id(),g.getId());
    }
}
