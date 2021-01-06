<?php 
include_once('lib/nusoap.php'); 
	
$servicio = new soap_server(); 



$servicio->configureWSDL( "Miservicio" ); 

$servicio->register( "devolverMensaje" , 
		
			array( 	'numero1' => 'xsd:int',
					'numero2' => 'xsd:int',
					'numero3' => 'xsd:int',
					'numero4' => 'xsd:int',), 
		
			array('return' => 'xsd:string'));


function devolverMensaje($numero1, $numero2, $numero3, $numero4){
	
	
	$array = array ($numero1, $numero2, $numero3, $numero4);
	$array2 = array ($numero1, $numero2, $numero3, $numero4);
			 

	$ascendente = "";
    $descendente = "";
	arsort($array); //descentente
	asort($array2);//ascendente
	

	foreach ($array as $key => $val) {
   		 $descendente = $descendente." "."$val";
	}

	foreach ($array2 as $key2 => $val1) {
	    $ascendente = $ascendente." "."$val1";
	}
	
	$resultado = "Ordenan ascendente:"." ".$ascendente." "."Orden descendente : ".$descendente; 
	
 	return $resultado; 

	} 

$servicio->service(file_get_contents("php://input"));
 
?>