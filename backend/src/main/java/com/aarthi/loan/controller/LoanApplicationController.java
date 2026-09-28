package com.aarthi.loan.controller;
import com.aarthi.loan.model.*;
import com.aarthi.loan.service.LoanApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins="http://localhost:5173")
public class LoanApplicationController {
 private final LoanApplicationService service;
 public LoanApplicationController(LoanApplicationService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public LoanApplication create(@RequestBody LoanApplication a){return service.submit(a);}
 @GetMapping public List<LoanApplication> all(){return service.findAll();}
 @GetMapping("/{id}") public LoanApplication one(@PathVariable Long id){return service.findById(id);}
 @GetMapping("/status/{status}") public List<LoanApplication> status(@PathVariable LoanStatus status){return service.findByStatus(status);}
}
