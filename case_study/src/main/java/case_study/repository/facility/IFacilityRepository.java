package case_study.repository.facility;


import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Modifying
    @Query(value = "update facility " +
            "set delete_status= 1 " +
            "where facility_id = :keywordId", nativeQuery = true)
    void deleteById(@Param("keywordId") int id);

    @Query(value = "select * " +
            "from facility " +
            "where facility_name like %:name% " +
            "and delete_status=0", nativeQuery = true)
    Page<Facility> searchByName(@Param("name") String name, Pageable pageable);
}
