<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16-3-9
  Time: 上午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#txt").change(function () {
                $.ajax({
                    url: "servlet/ImageServlet",
                    type: "POST",
                    data: {"txt": $(this).val()},
                    dataType: "text",
                    success: function (data) {
                        $("#img").attr("src", data).show();
                    }
                });
            })
        })
    </script>
</head>
<body>
请输入文字：<input type="text" id="txt"/>
<br/>

<div>
    <img id="img" src="" style="display: none;"/>
</div>
</body>
</html>