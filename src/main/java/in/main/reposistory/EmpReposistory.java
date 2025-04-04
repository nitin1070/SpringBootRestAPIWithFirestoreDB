package in.main.reposistory;

import in.main.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmpReposistory extends JpaRepository<Emp, Integer> {
    public Optional<Emp>findByName(String name);
    public Optional<Emp>findById(Integer empId);
}