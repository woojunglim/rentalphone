package pb.testphone.domain;

import lombok.Getter;
import lombok.Setter;
import pb.testphone.exception.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Phone {

    @Id
    @Column(name = "phone_id")
    private Long id;

    private String name;
    private String osName;
    private int stockQuantity;

    @ManyToMany(mappedBy = "phones")
    private List<Category> cateories = new ArrayList<Category>();

    // 도메인 주도 설계 : 엔티티 자체가 해결할 수 있으면 도메인 내에서 비즈니스 로직을 해결하는 것이 더 객체지향적

    /**
     * stock 증가
     */
    public void addStock() {
        this.stockQuantity += 1;
    }

    /**
     * stock 감소
     * @param quantity
     */
    public void removeStock(int quantity) {
        int restStock = stockQuantity - quantity;
        if(restStock < 0 ){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity -= quantity;
    }
}
