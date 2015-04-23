<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<div class="sidebar" id="sidebar">
<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<ul class="nav nav-list">
	<li class="active">
		<a href="index.jsp">
			<i class="icon-dashboard"></i>
			<span class="menu-text"> 控制台 </span>
		</a>
	</li>

	<li>
		<a href="#" class="dropdown-toggle">
			<i class="icon-desktop"></i>
			<span class="menu-text"> Mybatis </span>

			<b class="arrow icon-angle-down"></b>
		</a>

		<ul class="submenu">
			<li>
				<a href="tables.jsp">
					<i class="icon-double-angle-right"></i>
					connection database
				</a>
			</li>
		</ul>
	</li>

</ul><!-- /.nav-list -->

<div class="sidebar-collapse" id="sidebar-collapse">
	<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
</div>