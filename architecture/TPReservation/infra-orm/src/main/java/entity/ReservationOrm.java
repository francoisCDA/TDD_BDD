package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOrm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private Long id;

    private String userName;
    private Date begin;
    private Date end;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "meeting_room_id")
    private MeetingRoomOrm meetingRoomOrm;


    public Reservation toReservationDomaine() {
        return new Reservation(id,userName,begin,end);
    }
}
