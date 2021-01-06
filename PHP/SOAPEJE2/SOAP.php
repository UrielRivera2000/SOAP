<?php 
include_once('lib/nusoap.php'); 
	
$servicio = new soap_server(); 



$servicio->configureWSDL( "Miservicio" ); 

$servicio->register( "devolverMensaje" , 
		
			array( 	'numero1' => 'xsd:int',
					'numero2' => 'xsd:int',
					'numero3' => 'xsd:int',
					'numero4' => 'xsd:int',
					'numero5' => 'xsd:int',), 
		
			array('return' => 'xsd:string'));



function devolverMensaje($numero1, $numero2, $numero3, $numero4, $numero5){
	
	$pares = 0;
	$impares = 0;
	$ceros = 0;
	$acumPares =0;
	$acumImpares = 0;
	
	$array = array ($numero1, $numero2, $numero3, $numero4, $numero5);
		$count = count($array);
	
for ($i = 0; $i < $count; $i++) {
	
	if ($array[$i]== 0){
		$ceros++;
		
	}else{
		if($array[$i]%2 == 0){
		$pares++;
		$acumPares = $acumPares +$array[$i];
		}else{
			$impares++;
				$acumImpares = $acumImpares +$array[$i];
		}
	}
  
}

	
$resultado = "Cantidad Pares:"." ".$pares." "."Cantidad impares : ".$impares." Cantidad de ceros ".$ceros." Suma pares: ".$acumPares." "." Suma Impares ".$acumImpares; 
	
 return $resultado; 

} 

$servicio->service(file_get_contents("php://input"));
 
?>