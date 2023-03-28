package com.example.studentregistration.controller;

import com.example.studentregistration.dto.StudentDTO;
import com.example.studentregistration.jwt.JwtTokenUtil;
import com.example.studentregistration.model.Student;

import com.example.studentregistration.repository.StudentRepository;
import com.example.studentregistration.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.SecurityConfiguration;

import javax.validation.Valid;

@RestController
@Tag(name = "Auth", description = "The Auth API. Contains all the operations login and register.")

public class AuthController {
	@Autowired AuthenticationManager authManager;
	@Autowired
	JwtTokenUtil jwtUtil;

	@Autowired
	private StudentService studentService;

	StudentRepository studentRepository;






	@PostMapping("/auth/register")
	public ResponseEntity<?> register(@RequestBody @Valid AuthRequest registerRequest) {


//		if (studentService.findByEmail(registerRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new AuthResponse("This email is already registered."));
//		}

//		if (studentRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
//			return ResponseEntity.badRequest().body("This email is already registered.");
//		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(registerRequest.getPassword());

		Student newUser = new Student(registerRequest.getEmail(), password);

		Student savedUser = studentService.save(newUser);
		savedUser.getId();


		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						registerRequest.getEmail(), registerRequest.getPassword())
		);

		Student user = (Student) authentication.getPrincipal();
		String accessToken = jwtUtil.generateAccessToken(user);
		AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

		return ResponseEntity.ok().body(response);

//		AuthResponse response = new AuthResponse("Registration completed");
//		return ResponseEntity.ok(response);
//
//		return  ResponseEntity.ok("Registration completed");
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(), request.getPassword())
			);

			Student user = (Student) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
