package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRoomOrm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meetingroom", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    private int capacity;

    @ToString.Exclude
    @OneToMany(mappedBy = "meetingRoomOrm", orphanRemoval = true)
    private List<ReservationOrm> reservationOrms = new ArrayList<>();

    public MeetingRoom toMeetingRoomdomaine() {
        List<Reservation> reservationList = new ArrayList<>();
        if (reservationOrms != null && !reservationOrms.isEmpty()) {
            for (ReservationOrm re:reservationOrms) {
                reservationList.add(reservationOrms.toReservationDomaine());
            }
        }
    }

}
