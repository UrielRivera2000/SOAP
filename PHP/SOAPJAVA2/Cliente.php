
<form action="Cliente.php" method="post">
			<p>Número: <input type="number" name="numero"id ="numero" /></p>

			
			<p><input type="submit" /></p>
</form>
<?php 
	include_once('lib/nusoap.php'); 
		$wsdl  ="http://localhost:8000/Servicio?wsdl";
	
		$numero = $_POST["numero"];
		
		try{
	
			
			$cliente = new SoapClient($wsdl,'true') or die ("Error");
			$params = array($numero);
			$return = $cliente->call("devolverMensaje", $params);
			echo $return;
			
		
		}catch(SoapFault $exception){
			echo $exception->getMessage;
		}

 
?>