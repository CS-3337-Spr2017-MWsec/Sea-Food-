<?php

$mysql_hostname = "cs3.calstatela.edu";

$mysql_user = "cs3220stu101";

$mysql_password = "5gXHI4P5";

$mysql_database = "member";

$prefix = "";

$bd = mysql_connect($mysql_hostname, $mysql_user, $mysql_password) or die("Could not connect database");

mysql_select_db($mysql_database, $bd) or die("Could not select database");

?>
