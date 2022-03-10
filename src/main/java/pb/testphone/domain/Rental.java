package pb.testphone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rentals")
@Getter @Setter
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalPhone> rentalPhones = new ArrayList<>();

    private LocalDateTime rentalTime; // 대여시간

    @Enumerated(EnumType.STRING)
    private RentalState status; // 대여상태 [REMTAL, RETURN]

    public void setMember(Member member) {
        this.member = member;
        member.getRentals().add(this);
    }

    public void addRentalPhone(RentalPhone rentalPhone) {
        rentalPhones.add(rentalPhone);
        rentalPhone.setRental(this);
    }
}
