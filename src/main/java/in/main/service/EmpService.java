package in.main.service;

import in.main.entity.Emp;
import in.main.exception.EmpAlreadyExistException;
import in.main.exception.NoSuchEmpExistException;
import in.main.reposistory.EmpReposistory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.main.entity.updatedEmptDTO;

import java.util.Optional;

@Service
public class EmpService {
       private EmpReposistory empRepo;
    @Autowired
    public EmpService(EmpReposistory empRepo) {
        this.empRepo = empRepo;
    }
    public String addEmp(Emp emp) {
        Emp e = empRepo.findByName(emp.getName()).orElse(null);
        if(e!=null) {
            throw new EmpAlreadyExistException("Emp with name "+emp.getName()+" already exist");
        }
        empRepo.save(emp);
        return "emp added successfully";

    }
    public Emp getEmp(Integer empId) {
        Emp e = empRepo.findById(empId).orElse(null);
        if(e==null) {
            throw new NoSuchEmpExistException("Empt wiht id " + empId+" not found");
        }
        return e;

    }
    public String updateEmp(updatedEmptDTO updatedEmp,Integer empId) {
        Emp e = empRepo.findById(empId).orElse(null);
        if(e==null) {
            throw new NoSuchEmpExistException("Empt wiht id " + empId+" not found");
        }
        if(updatedEmp.getName()==null || updatedEmp.getName().isEmpty()){
            throw new RuntimeException("Name & Age is required");
        }
        if(updatedEmp.getName()!=null && updatedEmp.getName().isBlank()){
            throw new RuntimeException("Blank space not allowed");
        }
        if(updatedEmp.getName()!=null){
            e.setName(updatedEmp.getName());
        }
        if(updatedEmp.getAge()!=null ){
            e.setAge(updatedEmp.getAge());
        }
        empRepo.save(e);
        return "Emp with id "+empId+" updated successfully ";

    }
    public String deleteEmp(Integer empId){
        Optional<Emp> existingEmp = empRepo.findById(empId);
        if(existingEmp.isEmpty()){
            throw new NoSuchEmpExistException(("Record Not Found For Emp Id "+empId));
        }
        empRepo.deleteById(empId);
return  "Emp with id "+empId +" deleted successfully";
    }



}
