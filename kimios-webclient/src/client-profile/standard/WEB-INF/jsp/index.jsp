<%@ page import="org.kimios.client.controller.SecurityController" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%--
  ~ Kimios - Document Management System Software
  ~ Copyright (C) 2012-2013  DevLib'
  ~
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU Affero General Public License as
  ~ published by the Free Software Foundation, either version 2 of the
  ~ License, or (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU Affero General Public License for more details.
  ~ You should have received a copy of the GNU Affero General Public License
  ~ along with this program.  If not, see <http://www.gnu.org/licenses/>.
  --%>

<%
    //check mobile browser
    String ua = request.getHeader("User-Agent").toLowerCase();
    if (ua.matches(
            ".*(android|avantgo|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|symbian|treo|up\\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino).*") ||
            ua.substring(0, 4).matches(
                    "1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|e\\-|e\\/|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\\-|2|g)|yas\\-|your|zeto|zte\\-")) {
        response.sendRedirect(request.getContextPath() + "/mobile/index.jsp");
        return;
    }

    SecurityController securityController = null;
    WebApplicationContext wac =
            WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig().getServletContext());
    if (securityController == null) {
        securityController = (SecurityController) wac.getBean("securityController");
    }

    // check and redirect to main page if session is alive
    String sessionUid = (String) request.getSession().getAttribute("sessionUid");
    if (sessionUid != null && securityController.isSessionAlive(sessionUid)) {
        response.sendRedirect(request.getContextPath() + "/logged.jsp");
        return;
    }
    /*
    System.setProperty("javax.net.ssl.keyStore", "/path/to/client.ks");
    System.setProperty("javax.net.ssl.keyStorePassword", "secret");
    System.setProperty("javax.net.ssl.keyStoreType", "JKS");
    System.setProperty("javax.net.ssl.trustStore", "/path/to/client.ts");
    System.setProperty("javax.net.ssl.trustStorePassword", "secret");
    System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
    */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <link rel="shortcut icon" type="image/png" href="<%=request.getContextPath()%>/images/kimios-favico.ico"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/ext/resources/css/ext-all.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/ext/resources/css/kimios-theme.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home-style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/client-dm-viewer.css"/>
    <title>Kimios Web Explorer</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/ext-all.js"></script>
    <%@include file="/WEB-INF/jsp/core/init.jsp" %>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/kimios.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/Cookies.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/record.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/store.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/i18n/Internationalization.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/MessageBox.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/form/AuthenticationSourceField.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/main/FormPanel.js"></script>
    <script type="text/javascript" language="javascript"
            src="<%=request.getContextPath()%>/js/client/security/login.js"></script>
    <style rel="stylesheet" type="text/css">
        body {
            /*background-image: url(<%=request.getContextPath()%>/images/explorer_background.png);*/
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: right bottom;
        }
    </style>
</head>
<body style="background-color: white">
<div align="center"><br/><br/><img src="images/logo.png" class="logo-login-page"/></div>
<div id="login-area"></div>
</body>
</html>


