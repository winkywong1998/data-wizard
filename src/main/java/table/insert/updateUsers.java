//package table.insert;
//
//import table.dao.BaseDao;
//import table.entities.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class updateUsers{
//    private BaseDao bdao = new BaseDao();
//
//    private List<User> buildData(){
//        List<User> users = new ArrayList<User>();
//        for (int i = 1; i <= 5000000; i++) {
//            Goods gd = new Goods(i,"商品"+i
//                    ,rand.nextInt(10000)
//                    ,1+rand.nextInt(14),1,100
//                    ,1+rand.nextInt(99),1,"healthvalue");
//            gds.add(gd);
//        }
//        return users;
//    }
//
//    public void insert (){
//        List<Goods> gds = buildData();
//        long time = System.currentTimeMillis();
//        for (Goods gd : gds) {
//            String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
//            Object [] params={ gd.getGoodid(),gd.getTitle(),gd.getPrice(),gd.getTypeid(),
//                    gd.getIssale(),gd.getScore(),gd.getShopid()
//                    ,gd.getPaytype(),gd.getDetailname()};
//            bdao.update(sql,params);
//        }
//        System.out.println(System.currentTimeMillis()-time);
//    }
//}
