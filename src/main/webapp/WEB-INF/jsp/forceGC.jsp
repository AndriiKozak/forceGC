<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Force garbage collection</title>
    </head>    
    <body>
        ${result}<br/>
        <form action="forceGC">
            <input type="submit" value="force garbage collection"/>
        </form>       
    </body>
</html>
