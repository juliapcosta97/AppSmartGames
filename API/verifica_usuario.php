<?php

	$conexao=mysqli_connect("localhost", "root", "bcd127","dbsmartgames");
	

	$usuario=$_GET['usuario'];
	$senha=$_GET['senha'];
	
	$sql="select * from tblusuario
		where login='$usuario' and senha = '$senha'";

	$insere=mysqli_query($conexao, $sql);
	
	if($resultadoC = mysqli_fetch_assoc($insere)) {
		
		$retorno = array("codUsuario" => $resultadoC['codUsuario'] , "login" => $resultadoC['login'], "senha" => $resultadoC['senha']);
				
		echo json_encode($retorno);
	}
?> 