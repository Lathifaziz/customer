package speedrun.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import speedrun.customer.model.Course;
import speedrun.customer.service.CourseService;
import speedrun.customer.utill.response.PageWrapper;
import speedrun.customer.utill.response.Res;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    public final CourseService courseService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Course req){
        return Res.renderJson(
                courseService.create(req),
                "create",
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public Course getOne(@PathVariable Integer id){
        return courseService.getOne(id);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name,
                                 @RequestParam (required = false) Integer price,
                                 @PageableDefault(page = 0,size = 10)Pageable pageable){
        Page<Course> pc = courseService.getAll(name,price,pageable);
        PageWrapper<Course> pwc = new PageWrapper<>(pc);
        return Res.renderJson(
                pwc,"success", HttpStatus.OK
        );
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
}
