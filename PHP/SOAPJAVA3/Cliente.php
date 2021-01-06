
<p><h2>VAMOS A OBTENER SU RFC :3</h2></p>
<form action="Cliente.php" method="post">
			<p>Nombre: <input type="text" name="nombre"id ="nombre" /></p>
			<p>Apellido Paterno: <input type="text" name="apellidoP"id ="apellidoP"/></p>
			<p>Apellido Materno: <input type="text" name="apellidoM"id ="apellidoM"/></p>
			<p>Fecha: <input type="date" name="fecha"id ="fecha" /></p>
						
			<p><input type="submit" /></p>
</form>
<?php 
	include_once('lib/nusoap.php'); 
		$wsdl  ="http://localhost:9000/Servicio?wsdl";
	
		$nombre = $_POST["nombre"];
		$apellidoP = $_POST["apellidoP"];
		$apellidoM = $_POST["apellidoM"];
		$fecha = $_POST["fecha"];
		try{
	
			
			$cliente = new SoapClient($wsdl,'true') or die ("Error");
			$params = array($nombre,$apellidoP,$apellidoM,$fecha);
			$return = $cliente->call("rfc", $params);
			echo $return;
					
		}catch(SoapFault $exception){
			echo $exception->getMessage;
		}

 
?>