<?php
// wait a second to simulate a some latency
usleep(500000);
$miaoShaUser = $_REQUEST['miaoShaUser'];
$pw = $_REQUEST['password'];
if($miaoShaUser && $pw && $pw == "foobar")
	echo "Hi $miaoShaUser, welcome back.";
else
	echo "Your password is wrong (must be foobar).";
?>