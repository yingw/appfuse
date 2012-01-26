<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
    <head>
        <meta http-equiv="Cache-Control" content="no-store"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap.min.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
    <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>

    <div class="navbar navbar-fixed">
        <div class="navbar-inner">
            <div class="fluid-container">
                <a class="brand" href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a>
                <menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
                <ul class="nav">
                    <c:if test="${empty pageContext.request.remoteUser}">
                        <li class="active">
                            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
                        </li>
                    </c:if>
                    <menu:displayMenu name="MainMenu"/>
                    <menu:displayMenu name="UserMenu"/>
                    <menu:displayMenu name="AdminMenu"/>
                    <menu:displayMenu name="Logout"/>
                </ul>
                </menu:useMenuDisplayer>

                <c:if test="${pageContext.request.locale.language ne 'en'}">
                    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>">
                        <fmt:message key="webapp.name"/> in English</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <div class="fluid-container${(currentMenu == 'AdminMenu') ? ' sidebar-right' : ''}">
        <c:if test="${currentMenu == 'AdminMenu'}">
        <div class="fluid-sidebar">
            <menu:useMenuDisplayer name="Velocity" config="navlistMenu.vm" permissions="rolesAdapter">
                <menu:displayMenu name="AdminMenu"/>
            </menu:useMenuDisplayer>
        </div>
        </c:if>

        <div class="fluid-content">
            <%@ include file="/common/messages.jsp" %>
            <h2><decorator:getProperty property="meta.heading"/></h2>
            <decorator:body/>
        </div>
    </div>

    <div id="footer">
        <span class="left"><fmt:message key="webapp.version"/>
            <c:if test="${pageContext.request.remoteUser != null}">
            | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
            </c:if>
        </span>
        <span class="right">
            &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
        </span>
    </div>

<script type="text/javascript" src="<c:url value='/scripts/lib/jquery-1.7.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-alert.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-collapse.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-dropdown.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
<%= (request.getAttribute("scripts") != null) ?  request.getAttribute("scripts") : "" %>
</body>
</html>
