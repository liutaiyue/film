package cn.tarena.film.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.Type;
import cn.tarena.film.service.FilmService;
import cn.tarena.film.service.TypeService;

@Controller
@RequestMapping("/back")
public class BackFilmController extends BaseController {
	@Resource
	private FilmService filmService;
	@Resource
	private TypeService typeService;
	@RequestMapping("filmlist")
	public String findAll(Model model){
		List<Film> filmList = filmService.findAll();
		model.addAttribute("filmList", filmList);
		return "/back/film_list";
		
	}
	@RequestMapping("ToFilmCreate")
	public String ToFilmCreate(Model model){
		List<Type> typeList = typeService.findAll();
		model.addAttribute("typeList", typeList);
		return "/back/addFilm";
	}
	@RequestMapping("saveFilm")
	public String saveFilm(@RequestParam(value = "file", required = false) MultipartFile file,MultipartFile video,Film film, HttpServletRequest request){
		  // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + file.getOriginalFilename();  
                String url = "upload/"+file.getOriginalFilename();
                film.setFilmImage(url);
                // 转存文件  
                file.transferTo(new File(filePath)); 
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
        //上传视频文件
        if (!video.isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "video/"  
                        + video.getOriginalFilename();  
                String url = "video/"+video.getOriginalFilename();
                film.setMovieUrl(url);
                // 转存文件  
                video.transferTo(new File(filePath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        } 
		filmService.saveFilm(film);
		return "redirect:/back/filmlist";
	}
	@RequestMapping("deleteFilm")
	public String deleteFilm(Integer[] filmId){
		filmService.deleteFilm(filmId);
		return "redirect:/back/filmlist";
	}
}
