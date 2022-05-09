package firstrestapi.springrestapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table (name = "tbl_employee")

public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column (name = "id") DB'de aynı olacağı için kullanmaya gerek yok
    private Long id;

    //@Column (name = "name")
    @NotBlank(message = "Name should not be empty")
    private String name;

    //@Column (name = "surname")
    private String surname;

    @Email (message = "email should valid format")
    //@Column (name = "email")
    private String email;

    //@Column (name = "department")
    @NotBlank(message = "department should not be empty")
    private String department;

    //@Column (name = "location")
    private String location;

    //@Column (name = "age")
    private long age=0;

    @CreationTimestamp
    @Column (name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column (name = "updated_at")
    private Date updatedAt;

}
