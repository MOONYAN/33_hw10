<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <sec:csrfMetaTags />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Insert title here</title>
  </head>
  <body>
    <div class="container text-center">
      <div class="row">
        <div class="col-sm-12">
          <div class="thumbnail">
            <img src="http://5.blog.xuite.net/5/c/0/2/237233321/blog_3205507/txt/134162274/0.jpg" alt="..."/>
            <div class="caption">

              <div class="panel panel-primary">
                <div class="panel-heading">Login</div>
                <table class="table">
                  <form name="authForm" action="" method="post">
                    <tr>
                      <td>
                        <label>
                          <input id="_usernameText" name="username" type="text" value="${userModel.username}" placeholder="username"/>
                        </label>
                      </td>
                      <td>
                        <label>
                          <input id="_passwordText" name="password" type="password" value="${userModel.password}" placeholder="password"/>
                        </label>
                      </td>
                      <td>
                        <input class="btn btn-primary" type="button" value="Regist" onclick="onRegist(this.form)"/>
                        <input class="btn btn-primary" type="button" value="Login" onclick="onLogin(this.form)"/>
                      </td>
                    </tr>
                    <sec:csrfInput />
                  </form>
                </table>
              </div>

            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="alert alert-danger text-center" role="alert">${errorMessage}</div>
        <div class="alert alert-success text-center" role="alert">${message}</div>
      </div>



    </div>
  </body>
  <script src="http://code.jquery.com/jquery-3.1.1.min.js" charset="utf-8"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">

  function onRegist($regist)
  {
    $('form[name = authForm]').attr('action','regist');
    $regist.submit();
  }

  function onLogin($login)
  {
    $('form[name = authForm]').attr('action','login');
    $login.submit();
  }

  </script>
  <script type="text/javascript">
		window.contextPath = "${pageContext.request.contextPath}";
  </script>
</html>
