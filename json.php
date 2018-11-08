<?php
$n=0;
$r=array();
while($n<10)
{
array_push($r,array("num1"=>$n+1,"num2"=>$n+2));
$n=$n+1;
}
echo json_encode(array("server_response"=>$r));
?>