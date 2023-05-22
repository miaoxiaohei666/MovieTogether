package movie.controller;

import com.alibaba.fastjson.JSONObject;
import movie.dao.bean.MovieBean;
import movie.dao.bean.ScreeningBean;
import movie.dao.model.CinemaModel;
import movie.dao.model.MovieModel;
import movie.dao.model.ScreeningModel;
import movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.JWT;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    MovieModel movieModel;
    @Autowired
    ScreeningModel screeningModel;
    @Autowired
    CinemaModel cinemaModel;

    //获取所有电影信息,用于首页
    @PostMapping(value = "/movie/all")
    public String getAllInfo() {
        List<MovieBean> list = movieModel.findAll();
        JSONObject response = new JSONObject();
        response.put("list", list);
        response.put("msg", "ok！");
        return response.toString();
    }

    //获取某一电影的详细信息
    @PostMapping(value = "/movie/detail")
    public String getInfo(@RequestBody JSONObject request) {//id
        JSONObject response = new JSONObject();
        Integer id = Integer.valueOf(request.getString("id"));
        if (!movieModel.existsById(id)) {
            response.put("msg", "该电影信息不存在！");
            return response.toString();
        }
        MovieBean movie = movieModel.findMovieById(id);
        response.put("movie", movie);
        return response.toString();
    }

    //获取某一标签的所有电影信息
    @PostMapping(value = "/movie/label")
    public String getInfoByLabel(@RequestBody JSONObject request) {//label
        JSONObject response = new JSONObject();
        String label = request.getString("label");
        List<MovieBean> list = movieModel.findAllBySort(label);
        response.put("list", list);
        response.put("msg", "ok！");
        return response.toString();
    }

    //通过电影id获取所有场次信息
    @PostMapping(value = "/movie/screening")
    public String getScreening(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        Integer id = request.getInteger("id");
        List<ScreeningBean> list = movieService.getScreeningByMovieId(id);
        response.put("list", list);
        MovieBean movie = movieModel.findMovieById(id);
        response.put("movie", movie);
        response.put("msg", "ok");
        return response.toString();
    }


//    //添加电影信息
//    @PostMapping(value = "/movie/add")
//    public String addMovie(@RequestBody TokenAndMovie request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (movieModel.existsMovieBeanByName(request.movie.getName())) {
//            response.put("msg", "添加的电影信息已存在！");
//            return response.toString();
//        }
//        System.out.println(request.movie.getId());
//        movieModel.save(request.movie);
//        response.put("msg", "添加成功！");
//        return response.toString();
//    }
//
//    //修改电影信息
//    @PostMapping(value = "/movie/update")
//    public String updateMovie(@RequestBody TokenAndMovie request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!movieModel.existsById(request.movie.getId())) {
//            response.put("msg", "待更改的电影信息不存在！");
//            return response.toString();
//        }
//        if (movieModel.existsMovieBeanByName(request.movie.getName())) {
//            response.put("msg", "更改的电影名称已存在！");
//            return response.toString();
//        }
//        movieModel.save(request.movie);
//        response.put("msg", "修改成功！");
//        return response.toString();
//    }
//
//    //删除电影信息
//    @PostMapping(value = "/movie/delete")
//    public String deleteMovie(@RequestBody TokenAndMovie request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!movieModel.existsById(request.movie.getId())) {
//            response.put("msg", "待删除的电影信息不存在！");
//            return response.toString();
//        }
//        movieModel.deleteById(request.movie.getId());
//        response.put("msg", "删除成功！");
//        return response.toString();
//    }
//
//    //添加电影场次信息
//    @PostMapping(value = "/screening/add")
//    public String addScreening(@RequestBody TokenAndScreening request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        screeningModel.save(request.screening);
//        response.put("msg", "添加成功！");
//        return response.toString();
//    }
//
//    //修改电影场次信息
//    @PostMapping(value = "/screening/update")
//    public String updateScreening(@RequestBody TokenAndScreening request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!screeningModel.existsById(request.screening.getId())) {
//            response.put("msg", "待更改的电影场次信息不存在！");
//            return response.toString();
//        }
//        screeningModel.save(request.screening);
//        response.put("msg", "修改成功！");
//        return response.toString();
//    }
//
//    //删除电影场次
//    @PostMapping(value = "/screening/delete")
//    public String deleteScreening(@RequestBody TokenAndScreening request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!screeningModel.existsById(request.screening.getId())) {
//            response.put("msg", "待删除的电影场次信息不存在！");
//            return response.toString();
//        }
//        screeningModel.deleteById(request.screening.getId());
//        response.put("msg", "删除成功！");
//        return response.toString();
//    }
//    //添加影院信息
//    @PostMapping(value = "/cinema/add")
//    public String addCinema(@RequestBody TokenAndCinema request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        cinemaModel.save(request.cinema);
//        response.put("msg", "添加成功！");
//        return response.toString();
//    }
//
//    //修改影院信息
//    @PostMapping(value = "/cinema/update")
//    public String updateCinema(@RequestBody TokenAndCinema request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!cinemaModel.existsById(request.cinema.getId())) {
//            response.put("msg", "待更改的电影场次信息不存在！");
//            return response.toString();
//        }
//        cinemaModel.save(request.cinema);
//        response.put("msg", "修改成功！");
//        return response.toString();
//    }
//
//    //删除影院信息
//    @PostMapping(value = "/cinema/delete")
//    public String deleteCinema(@RequestBody TokenAndCinema request) {
//        String role = JWT.parseRoleFromToken(request.token);
//        JSONObject response = new JSONObject();
//        if (!role.equals("1")) {
//            response.put("msg", "权限不足!");
//            return response.toString();
//        }
//        if (!cinemaModel.existsById(request.cinema.getId())) {
//            response.put("msg", "待删除的电影场次信息不存在！");
//            return response.toString();
//        }
//        cinemaModel.deleteById(request.cinema.getId());
//        response.put("msg", "删除成功！");
//        return response.toString();
//    }

//    static class TokenAndMovie {
//        public String token;
//        public MovieBean movie;
//    }
//
//    static class TokenAndScreening {
//        public String token;
//        public ScreeningBean screening;
//    }
//    static class TokenAndCinema{
//        public String token;
//        public CinemaBean cinema;
//    }
}

//        "token":"eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE1OTAzMDMyMzc2Iiwicm9sZSI6MSwianRpIjoiNWVmOThhNTMtYzQ1OS00ODIyLTgyMDItMWJjOGE5YTZiNWIzIiwiZXhwIjoxNjU3MzUwNjcwfQ.S44R6RGc6IZro6CAPbcRS3m_5IgWYh8qyvPd2v2XZeo"

