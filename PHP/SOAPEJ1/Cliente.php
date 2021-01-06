
<form action="Cliente.php" method="post">
			<p>Su nombre: <input type="text" name="nombre" id ="nombre"/></p>
			<p>numero 1: <input type="number" name="numero1"id ="numero1" /></p>
			<p>numero 2: <input type="number" name="numero2" id ="numero2"/></p>
			<p>numero 3: <input type="number" name="numero3" id ="numero3"/></p>
			<p>numero 4: <input type="number" name="numero4" id ="numero4"/></p>
			<p><input type="submit" /></p>
</form>

<?php 
	include_once('lib/nusoap.php'); 
		$wsdl  ="http://localhost/SOAPEJ1/SOAP.php?wsdl";
		$nombre = $_POST["nombre"];
		$numero1 = $_POST["numero1"];
		$numero2 = $_POST["numero2"];
		$numero3 = $_POST["numero3"];
		$numero4= $_POST["numero4"];
		try{
	
			
			$cliente = new SoapClient($wsdl) or die ("Error");
			$params = array($nombre, $numero1,$numero2,$numero3,$numero4);
			$return = $cliente->call("devolverMensaje", $params);
			echo $return;
			
		
		}catch(SoapFault $exception){
			echo $exception->getMessage;
		}

 
?>

