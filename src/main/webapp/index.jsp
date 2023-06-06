<%@ page contentType="text/html; charset=UTF-8" %>

<%-- 一開始的首頁 --%>

<!DOCTYPE html>
<html>
    <head>
        <title>歡迎</title>
    </head>
    <body>
        <h1>歡迎來到我的網站!</h1>
        <form action="hello" method="post">
            <label for="name">請輸入第一個數字:</label>
            <input type="text"  name="number1"><br>
            <label for="name">請輸入第二個數字:</label>
           <input type="text"  name="number2"><br>
            <input type="submit" value="送出">
        </form>
    </body>
</html>