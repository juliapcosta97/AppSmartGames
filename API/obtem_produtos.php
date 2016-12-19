<?php

	
	$conexao=mysqli_connect("localhost", "root", "bcd127","dbsmartgames");

	
	
	$sql="select * from tblgame";
	
	$insere=mysqli_query($conexao, $sql);
	
    $jsonarray = array();
	
    while($row=mysqli_fetch_assoc($insere))
		
    {
		$jsonarray[] = $row;
		
    }

    echo json_encode($jsonarray);

?>