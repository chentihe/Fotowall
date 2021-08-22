package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	@RequestMapping(path= {"/"})
	public String index() {
		return "/index";
	}
	@RequestMapping(path= {"/fotowall"})
	public String fotoWall() {
		return "/fotowall";
	}
	@RequestMapping(path= {"/otherswall"})
	public String othersWall() {
		return "/otherswall";
	}
	@RequestMapping(path= {"/fotomanage"})
	public String fotoManage() {
		return "/fotomanage";
	}
}
