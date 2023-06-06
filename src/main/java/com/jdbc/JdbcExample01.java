package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: JdbcExample01
 * Package: com.jdbc
 * Description:
 * JDBC 操作
 *
 * @Author chgwyellow
 * @Create 2023-05-31
 */
public class JdbcExample01 {

    public static void main(String[] args) {

        String url = "See ya bitch";
        String user = "username";
        String password = "password";

        try {

            //和MySQL資料庫建立連線
            Connection connection = DriverManager.getConnection(url, user, password);

            //抓取sakila資料庫的名稱
            String dbName = connection.getCatalog();
            System.out.println("dbName = " + dbName);

            //SQL查詢指令
            String selectSQL = "select "
                    +"id, column1, column2 "
                    +"from table "
                    +"where id between ? and ? ";

            int beginNumber = 1;
            int endNumber = 2;

            //建立一個PrepareStatement物件 用來傳送SQL的指令
            PreparedStatement pstmt = connection.prepareStatement(selectSQL);
            //setInt(index, object) 將selectSQL裡的?替代 index從1開始
            pstmt.setInt(1, beginNumber);
            pstmt.setInt(2, endNumber);

            //執行查詢
            ResultSet resultSet = pstmt.executeQuery();
            System.out.println("resultSet = " + resultSet);

            //查到的資料存在List裡面
            List<Entity> entityList = new ArrayList<>();

            while (resultSet.next()){
                Entity entity = new Entity();
                entity.setId(resultSet.getInt("id"));
                entity.setName(resultSet.getString("name"));
                entity.setAge(resultSet.getInt("age"));
                entityList.add(entity);
            }
            //print List物件內容
            for (Entity entity: entityList){
                System.out.println(entity);
            }

            // 關閉資料庫連線
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
