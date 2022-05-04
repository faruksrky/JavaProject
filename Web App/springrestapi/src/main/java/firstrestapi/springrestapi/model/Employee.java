package firstrestapi.springrestapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table (name = "tbl_employee")

public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "email")
    private String email;

    @Column (name = "department")
    private String department;

    @Column (name = "location")
    private String location;

    @Column (name = "age")
    private long age;
}
