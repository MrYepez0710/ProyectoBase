package com.ex.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.OperacionesDTO;

@RequestMapping("/test")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HelloWorldRest {
	
	@GetMapping(value="/holaMundo")
	public ResponseEntity<?> registrarSolicitud(@PathParam("nombre") String nombre){
		
		return ResponseEntity.status(HttpStatus.OK).body("Hello " + nombre + " In Java");
	}

	@GetMapping(value="/fechaHoraActual")
	public ResponseEntity<?> registrarSolicitud(){
		String fechaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		return ResponseEntity.status(HttpStatus.OK).body("Fecha y Hora Actual: " + fechaActual);
	}
	
	@PostMapping(value="/operaciones")
	public ResponseEntity<?> operacionesBasicas(@RequestBody OperacionesDTO dto) {

		double resultado = 0;

		switch (dto.getOperacion()) {
		case "+":
			resultado = dto.getNro1() + dto.getNro2();
			break;
		case "-":
			resultado = dto.getNro1() - dto.getNro2();
			break;
		case "*":
			resultado = dto.getNro1() * dto.getNro2();
			break;
		case "/":
			if (dto.getNro2() != 0)
				resultado = dto.getNro1() / dto.getNro2();
			else
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("El divisor debe ser diferente de 0");
			break;
		default:
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Las operaciones Permitidas son: +, -, *, /");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Resultado: " + resultado);
	}
}
