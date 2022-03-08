package pb.testphone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Phone {

    @Id @GeneratedValue
    @Column(name = "phone_id")
    private Long id;

    private String name;
    private int stockQuantity;

    @ManyToMany(mappedBy = "phones")
    private List<Category> cateories = new ArrayList<Category>();

}
