<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kale
  Date: 2016/12/22
  Time: 下午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>China Map</title>
    <%--<script type="text/javascript" src="js/raphael.js"></script>--%>
    <%--<script type="text/javascript" src="js/chinamapPath.js"></script>--%>
    <script src="${basePath}/styles/d3.js" type="text/javascript"></script>
    <script src="${basePath}/styles/main.js" type="text/javascript"></script>

</head>
<body>
<div id="main" style="width:100px;height:50px;"></div>
<div class="transitionsContainer"></div>
<div class="chinamap"></div>
<div>${requestScope.city}</div>

<script type="text/javascript">
    //    transitions();
    chinaMap("${basePath}/res/china.geojson");
</script>

</body>
</html>
