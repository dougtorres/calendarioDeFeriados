<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" /> 
    

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet"> 

  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="POST" action="login.do">
        <h2 class="form-signin-heading">Realizar Login</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Lembre-me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Logar</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
