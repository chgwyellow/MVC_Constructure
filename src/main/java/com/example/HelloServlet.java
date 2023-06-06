package com.example;


import com.jdbc.CityEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: com.example.HelloServlet
 * Package: PACKAGE_NAME
 * Description:
 * 這是MVC 的controller
 * MVC = model view controller
 *
 * @Author chgwyellow
 * @Create 2023-06-04
 */

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    //HttpServlet有許多請求方法可以重寫
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");

        int beginNumber = Integer.parseInt(number1);
        int endNumber = Integer.parseInt(number2);

        String url = "See ya";
        String user = "username";
        String password = "password";

        //查到的資料存在List裡面
        //這是MVC的model
        List<CityEntity> entityList = new ArrayList<>();

        try {

            //在Maven web專案底下 註冊mysql的驅動器 (driver)
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);

            //和MySQL資料庫建立連線
            Connection connection = DriverManager.getConnection(url, user, password);

            //SQL查詢指令
            String selectSQL = "select "
                    + "id, column1, column2 "
                    + "from table"
                    + "where id between ? and ? ";

            //建立一個PrepareStatement物件 用來傳送SQL的指令
            PreparedStatement pstmt = connection.prepareStatement(selectSQL);
            //setInt(index, object) 將selectSQL裡的?替代 index從1開始
            pstmt.setInt(1, beginNumber);
            pstmt.setInt(2, endNumber);

            //執行查詢
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                //model就是cityEntity DAO物件
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCity_id(resultSet.getInt("city_id"));
                cityEntity.setCity(resultSet.getString("city"));
                cityEntity.setCountry_id(resultSet.getInt("country_id"));
                entityList.add(cityEntity);
            }

//            for (CityEntity entity: entityList){
//                System.out.println(entity);
//            }

            // 關閉資料庫連線
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //把entityList設定到request層級的網頁狀態
        request.setAttribute("entityList", entityList);

        //將請求轉發到result.jsp，並將控制權交給該頁面進行處理和回應生成
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}