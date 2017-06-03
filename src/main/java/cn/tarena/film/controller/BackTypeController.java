package cn.tarena.film.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Type;
import cn.tarena.film.service.TypeService;


@Controller
@RequestMapping("/back")
public class BackTypeController {
	@Resource
	private TypeService typeService;
	//类型列表
	@RequestMapping("typelist")
	public String findAll(Model model){
		List<Type> typeList = typeService.findAll();
		model.addAttribute("typeList", typeList);
		return "/back/type_list";
	}
	
	//到创建页面
	@RequestMapping("toTypeCreate")
	public String crateType(){
		return "/back/addType";
	}
	//保存
	@RequestMapping("saveType")
	public String saveType(Type type){
		typeService.saveType(type);
		return "redirect:/back/typelist";
	}
	@RequestMapping("deleteType")
	public String deleteType(Integer[] typeId){
		typeService.deleteType(typeId);
		return "redirect:/back/typelist";
	}
}
