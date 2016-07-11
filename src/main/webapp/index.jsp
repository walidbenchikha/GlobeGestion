<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    
   <!--  
    <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style>
    
    --> 
    
    
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      </script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
    </style>
  </head>
  <body>
  
  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Map</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Shops <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#"> Auditors </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Planning <span class="caret"></span></a>
      <ul class="dropdown-menu">
          <li><a href="#">advertising campaigns</a></li>
          <li><a href="#"> Visits</a></li>
         
        </ul>
        </li>
      <li><a href="#"> Administrate </a></li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
  
  <!--  <div class="navbar navbar-fixed-top navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="addGoal.html">
            Get started
          </a>
          <ul class="nav">
          </ul>
        </div>
      </div>
    </div>
    
    
    -->
    <div class="container">
      <div class="hero-unit">
        <div>
          <h1>
            Welcome to Gestion <sec:authentication property="name"/>!
          </h1>
          
        </div>
        
        
        <a class="btn btn-primary" href="afficher.html">
          afficher »
        </a>
        
       
       <sec:authorize ifAnyGranted="ROLE_ADMIN"> 
        <a class="btn btn-primary" href="editGoal.html">
          add super user »
        </a>
        </sec:authorize>
        
         
       <sec:authorize ifAnyGranted="ROLE_USER"> 
        <a class="btn btn-primary" href="editGoal.html">
          add auditeur »
        </a>
        </sec:authorize>
        
        <sec:authorize ifAnyGranted="ROLE_AUDITEUR"> 
        <a class="btn btn-primary" href="editGoal.html">
          afficher »
        </a>
        </sec:authorize>

        
        <a class="btn btn-warning" href="j_spring_security_logout">
        	Logout >>
        
        </a>
        
        
      </div>
      <div>
      </div>
    </div>
    
   
    
    <script src="jquery-3.0.0.js">
    </script>
    
    <script src="assets/js/bootstrap.js">
    </script>
  </body>
</html>
