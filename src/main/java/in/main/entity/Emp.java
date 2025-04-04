package in.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer empId;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must be less than or equal to 65")
    private Integer age;
}
