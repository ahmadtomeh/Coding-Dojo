package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHelloHuman {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="lname", required=false) String lname, @RequestParam(value="times", required=false,defaultValue="1") int times) {
    	String a = "";
    	for(int x=0;x < times; x++) {
    		a +="Hello " + name + " ";
    	}
    	if (name != null) {
    		if(lname == null && times == 1) {
    		return "Hello " + name;
    		}
    		else if (lname != null && times == 1) {
    			return "Hello " + name + " " + lname;
    		}
    		else {
    			return a;
    		}
    		
    	}
    	else {
    		return "Hello Human";
    	}
    }
//...

}
