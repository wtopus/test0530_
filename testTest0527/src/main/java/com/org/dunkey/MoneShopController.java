package com.org.dunkey;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.domain.MemberVO;
import com.org.service.MoneService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/mone")
@RestController
@Log4j
@AllArgsConstructor
public class MoneShopController {
	private MoneService service;
	
	@CrossOrigin(origins = "*" )
	@PostMapping(value="/new", consumes="application/json", produces= {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<MemberVO> create(@RequestBody String a){
//		log.info("param : " + memberVO.getMid() + memberVO.getMpw());
//		return new ResponseEntity<>(service.isLogin(memberVO), HttpStatus.OK);
//	}
	public ResponseEntity<String> create(@RequestBody String a){
		log.info("param : " + a);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}


}
