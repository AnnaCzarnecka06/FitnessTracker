package pl.wsb.fitnesstracker.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.startDate > :now ORDER BY e.startDate")
    List<Event> findUpcoming(@Param("now") LocalDate now);

    @Query(
            value = "SELECT e.name AS eventName, COUNT(ue.user_id) AS participantsCount" +
                    "FROM event e" +
                    "LEFT JOIN user_event ue ON e.id = ue.event_id" +
                    "Group by e.id, e.name" +
                    "ORDER BY participantsCount DESC",
            nativeQuery = true
    )
    long countParticipants();
}
