package ru.specialist.spring.lab08.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.specialist.spring.lab08.dao.Course;
import ru.specialist.spring.lab08.dao.CourseService;

import java.util.List;

//@Controller
@RestController // @Controller + @ResponseBody on every method  
@RequestMapping("api/course")
public class CourseApiController {

    private CourseService courseService;

    @Autowired
    public void setContactService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET) //  api/course GET
    //@ResponseBody
    public List<Course> list() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // api/course/5
    //@ResponseBody
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST) // api/course/
    //@ResponseBody
    public Course create(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    //@ResponseBody
    public Course update(@RequestBody Course course, @PathVariable int id) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //@ResponseBody
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

}
