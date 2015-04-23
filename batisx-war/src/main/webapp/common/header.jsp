<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>batisx</title>
		<!-- basic styles -->
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="css/ace.min.css" />
		<link rel="stylesheet" href="css/ace-rtl.min.css" />
		<link rel="stylesheet" href="css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
    		<div class="navbar navbar-default" id="navbar">
    			<script type="text/javascript">
    				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    			</script>

    			<div class="navbar-container" id="navbar-container">
    				<div class="navbar-header pull-left">
    					<a href="#" class="navbar-brand">
    						<small>
    							<i class="icon-leaf"></i>
    							batisX
    						</small>
    					</a><!-- /.brand -->
    				</div><!-- /.navbar-header -->
    			</div><!-- /.container -->
    		</div>

    		<div class="main-container" id="main-container">
    			<script type="text/javascript">
    				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    			</script>

    			<div class="main-container-inner">
    				<a class="menu-toggler" id="menu-toggler" href="#">
    					<span class="menu-text"></span>
    				</a>