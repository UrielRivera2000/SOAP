<?php 
include_once('lib/nusoap.php'); 
	
$servicio = new soap_server(); 



$servicio->configureWSDL( "Miservicio" ); 

$servicio->register( "devolverMensaje" , 
		
			array( 	'nombre' => 'xsd:string',
					'numero1' => 'xsd:int',
					'numero2' => 'xsd:int',
					'numero3' => 'xsd:int',
					'numero4' => 'xsd:int',), 
		
			array('return' => 'xsd:string'));



function devolverMensaje($nombre, $numero1, $numero2, $numero3, $numero4){
$suma = $numero1+$numero2+$numero3+$numero4;
$producto = $numero1*$numero2*$numero3*$numero4;
$promedio = $suma/4;
	
$resultado = "Hola "." ".$nombre." "." el producto es: ".$producto." , la suma es ".$suma." y el promedio es: ".$promedio; 
	
 return $resultado; 

} 



$servicio->service(file_get_contents("php://input"));
 
?>