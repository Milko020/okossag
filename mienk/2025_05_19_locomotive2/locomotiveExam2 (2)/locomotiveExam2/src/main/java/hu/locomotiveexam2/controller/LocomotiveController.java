package hu.locomotiveexam2.controller;

import hu.locomotiveexam2.dto.LocomotiveListItem;
import hu.locomotiveexam2.dto.LocomotiveRead;
import hu.locomotiveexam2.dto.LocomotiveSave;
import hu.locomotiveexam2.service.LocomotiveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locomotive")
@Tag(name="Locomotive functions", description = "Create, read, update, delete or list locomotives")
public class LocomotiveController {

    @Autowired
    private LocomotiveService locomotiveService;

    @GetMapping("/list")
    @Operation(description = "List all locomotives")
    public List<LocomotiveListItem> listLocomotives() {
        return locomotiveService.listLocomotives();
    }

    @GetMapping("/{id}")
    public LocomotiveRead getLocomotive(@PathVariable Integer id){
        return locomotiveService.getLocomotive(id);
    }

    @PostMapping("/")
    public LocomotiveRead createLocomotive(@Valid @RequestBody LocomotiveSave locomotiveSave){
        return locomotiveService.createLocomotive(locomotiveSave);
    }

    @PutMapping("/{id}")
    public LocomotiveRead updateLocomotive(@PathVariable Integer id, @Valid @RequestBody LocomotiveSave locomotiveSave){
        return locomotiveService.updateLocomotive(id, locomotiveSave);
    }

    @DeleteMapping("/{id}")
    public LocomotiveRead deleteLocomotive(@PathVariable Integer id){
        return locomotiveService.deleteLocomotive(id);
    }
}
