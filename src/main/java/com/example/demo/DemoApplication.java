// package com.example.demo;

// // import org.springframework.boot.SpringApplication;
// // import org.springframework.boot.autoconfigure.SpringBootApplication;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.RequestParam;
// // import org.springframework.web.bind.annotation.RestController;

// // @SpringBootApplication
// // @RestController
// public class DemoApplication {


// 	@GetMapping("/hello")
// 	String home(){
// 		return "Hi Test!";
// 	}

// 	@GetMapping("/tester")
// 	String tai(){
// 		return "Hi tai";
// 	}

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 		System.out.println("adsasda");
// 	}

// 	@GetMapping("/name")
// 	String get_id(@RequestParam(value="name", defaultValue = "World") String name){
// 		return String.format("Wasssguuddd %s", name);
// 	}

// }
