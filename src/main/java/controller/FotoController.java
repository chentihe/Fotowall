package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.bean.Foto;
import dao.bean.User;
import service.FotoService;

@Controller
@RequestMapping(path= {"/foto"})
public class FotoController {
	@Autowired
	private FotoService fotoService;
	private Foto temp;
	@ModelAttribute
	public void addAttribute(Model model, HttpSession session) {
		User user = (User) session.getAttribute(Constant.USER_SESSION);
		String path = session.getServletContext().getRealPath("/static/upload");
		model.addAttribute("user", user);
		model.addAttribute("path", path);
	}
	
	@PostMapping(path= {"/upload"})
	public String upload(MultipartFile[] multiparts, Model model) {
		User user = (User) model.getAttribute("user");
		Map<String, String> errors = new HashMap<>();
// 存檔
		String path = (String) model.getAttribute("path");
		temp = new Foto();
		temp.setUid(user.getId());
		if (multiparts!=null && multiparts.length!=0) {
			for (MultipartFile multipart : multiparts) {
				String fileName = UUID.randomUUID().toString() + multipart.getOriginalFilename().substring(multipart.getOriginalFilename().lastIndexOf("."));
				temp.setFotoPath(fileName);
				try {
					multipart.transferTo(new File(path, fileName));
					fotoService.upload(temp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "redirect:/foto/show";
		}
		errors.put("upload", "Upload failed, please try again!");
		return "/index";
	}
	@GetMapping(path= {"/show"})
	public String show(Integer uid, String page, Model model) {
		User user = (User) model.getAttribute("user");
		temp = new Foto();
		temp.setUid(uid==null?user.getId():uid);
		Map<String, Integer> pagination = this.getPagination(temp, page);
		List<?> userWall = fotoService.getFotoList(temp, pagination.get("currentPage"), Constant.PAGE_SIZE);
		model.addAttribute("pagination", pagination);
		model.addAttribute("userWall", userWall);
		return "/fotowall";
	}
	@GetMapping(path= {"/browse"})
	public String browse(String page, Model model) {
		Map<String, Integer> pagination = this.getPagination(temp, page);
		List<?> othersFoto = fotoService.getFotoList(temp, pagination.get("currentPage"), Constant.PAGE_SIZE);
		model.addAttribute("pagination", pagination);
		model.addAttribute("othersFoto", othersFoto);
		return "/otherswall";
	}
	@GetMapping(path= {"/edit"})
	public String edit(String page, Model model) {
		User user = (User) model.getAttribute("user");
		temp = new Foto();
		temp.setUid(user.getId());
		Map<String, Integer> pagination = this.getPagination(temp, page);
		List<?> userWall = fotoService.getFotoList(temp, pagination.get("currentPage"), Constant.PAGE_SIZE);
		model.addAttribute("pagination", pagination);
		model.addAttribute("userWall", userWall);
		return "/fotomanage";
	}
	@PostMapping(path= {"/delete"})
	public String delete(String[] delNos, Model model) {
		if (delNos!=null && delNos.length!=0) {
			for (String delNo : delNos) {
				temp.setId(Integer.parseInt(delNo));
				Foto delete = fotoService.delete(temp);
				String path = (String) model.getAttribute("path");
				String delFile = delete.getFotoPath();
				File file = new File(path, delFile);
				file.delete();
			}
		}
		return "redirect:/foto/edit";
	}
	@GetMapping(path= {"/random"})
	public @ResponseBody Foto random() {
		Foto indexFoto = fotoService.getIndexFoto();
		return indexFoto;
	}
// 分頁方法
	private Map<String, Integer> getPagination(Foto foto, String page) {
		Map<String, Integer> pagination = new HashMap<>();
		int currentPage = (page==null)?1:Integer.parseInt(page);
		int totalPage = 0;
		int totalFoto = 0;
		totalFoto = fotoService.getFotoCount(foto);
		totalPage = (totalFoto + Constant.PAGE_SIZE -1)  / Constant.PAGE_SIZE;
		pagination.put("currentPage", currentPage);
		pagination.put("totalPage", totalPage);
		pagination.put("totalFoto", totalFoto);
		return pagination;
	}
}
