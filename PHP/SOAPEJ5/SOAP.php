<?php 
include_once('lib/nusoap.php'); 
	
$servicio = new soap_server(); 
 

$servicio->configureWSDL( "Miservicio"); 

$servicio->register( "devolverMensaje" , 
		
			array('palabra1' => 'xsd:string',
				  'palabra2' => 'xsd:string',
				  'palabra3' => 'xsd:string',
				  'palabra4' => 'xsd:string',
				  'palabra5' => 'xsd:string'), //variables de peticion
		
			array('return' => 'xsd:string'),// varaibles de retornoname
			"http://localhost/miservicio1",// alias de direccion, namespace
			"http://localhost/miservicio1#",// el gato indica que despues de eso nombraremos la acción(método) 
			"rpc",//permite mandar uno o muchos parametros
			"literal",//reglas de codificacion
			"Este es mi servicio"
			);



function devolverMensaje ($palb1, $palb2, $palb3, $palb4, $palb5) {	 
$Arreglo= array($palb1, $palb2, $palb3, $palb4, $palb5);


$count = count($Arreglo);

$concatenar="";


for ($i=0; $i < $count ; $i++) { 
	
        $concatenar = $concatenar." Palabra:".($i+1)."  ".str_replace("a","",$Arreglo[$i]);
        $concatenar = str_replace("e","",$concatenar);
        $concatenar = str_replace("i","",$concatenar);
        $concatenar = str_replace("o","",$concatenar);
        $concatenar = str_replace("u","",$concatenar);

        $concatenar = str_replace("A","",$concatenar);
        $concatenar = str_replace("E","",$concatenar);
        $concatenar = str_replace("I","",$concatenar);
        $concatenar = str_replace("O","",$concatenar);
        $concatenar = str_replace("U","",$concatenar);
        $concatenar = $concatenar."\n";
}

$resultado = "La cadena sin vocales es: \n".$concatenar."\n";

 return $resultado; 
}


$servicio->service(file_get_contents("php://input"));


?>