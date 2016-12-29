<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1"/>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/kendo-ui/styles/kendo.common.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/kendo-ui/styles/kendo.default.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/kendo-ui/styles/kendo.default.mobile.min.css" />
      <title>iMovie</title>
    </head>
    <body ng-app='iMovie'>
      <div ui-view class="container"></div>

      <table border="0" align="center">
        <tr>
          <td>
            <jsp:include page="menu.jsp"/>
          </td>
        </tr>
      </table>
    </body>
    <script type="text/javascript">
    window.contextPath = "${pageContext.request.contextPath}";
    </script>

    <jsp:include page="include.jsp"/>
  </html>
