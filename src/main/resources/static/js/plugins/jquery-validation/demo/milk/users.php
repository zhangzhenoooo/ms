<?php
$request = trim(strtolower($_REQUEST['username']));
//sleep(2);
usleep(150000);
$users = array('asdf', 'Peter', 'Peter2', 'George');
$valid = 'true';
foreach($users as $miaoShaUser) {
	if( strtolower($miaoShaUser) == $request )
		$valid = 'false';
}
echo $valid;
?>