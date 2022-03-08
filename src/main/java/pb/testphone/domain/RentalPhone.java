package pb.testphone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rental_phone")
@Getter @Setter
public class RentalPhone {

    @Id @GeneratedValue
    @Column(name = "rental_phone_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    private Phone phone; // 대여 폰

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental; // 대여

    private int count; // 대여 수량
}
