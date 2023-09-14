package ILearn.manage.repository;

import ILearn.manage.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManageRepository extends JpaRepository<Manage, Long> {
    @Query("SELECT m.manageId FROM Manage m")
    List<Long> findAllManageIds();

    @Query("SELECT MAX(m.manageId) FROM Manage m")
    Optional<Long> findMaxManageId();

    Manage findTopByOrderByManageNumDesc();
}
