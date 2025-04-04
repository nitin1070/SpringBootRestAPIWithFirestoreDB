package in.main.controller;

import in.main.entity.Emp;
import in.main.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import in.main.entity.updatedEmptDTO;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
    private EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/{empId}")
    public Emp getEmp(@PathVariable("empId") Integer empId) {
        return empService.getEmp(empId);
    }

    @PostMapping("/add")
    public String addEmp(@RequestBody @Valid Emp emp) {
        return empService.addEmp(emp);
    }
    @PutMapping("/update/{empId}")
    public String updateEmp(@RequestBody @Valid updatedEmptDTO updatedEmp,@PathVariable("empId")Integer empId) {
        return empService.updateEmp(updatedEmp, empId);
    }
    @DeleteMapping("/delete/{empId}")
    public  String deleteEmp(@PathVariable("empId")Integer empId){
  return empService.deleteEmp(empId);
    }
}
