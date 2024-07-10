package speedrun.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speedrun.customer.service.impl.TodoServiceImpl;
import speedrun.customer.utill.response.Res;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoServiceImpl todoService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return Res.renderJson(
                todoService.getAll(),
                "success",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        return Res.renderJson(
                todoService.getById(id),"Success",
                HttpStatus.OK
        );
    }
}