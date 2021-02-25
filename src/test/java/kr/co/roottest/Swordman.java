package kr.co.roottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
//@AllArgsConstructor
@RequiredArgsConstructor
public class Swordman {
	
	//@Autowired 필드 주입
	final Weapon weapon;
}
