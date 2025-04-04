package in.main.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class updatedEmptDTO {
     @Size(min = 1,max = 30,message = "Please provide a valid name")
    private String name;
     @NotNull(message = "Age is required")
     @Min(value = 18, message = "Age must be at least 18")
     @Max(value = 65, message = "Age must be less than or equal to 65")
    private Integer age;

}
