package ILearn.manage.repository;

import ILearn.manage.dto.ManageListDto;
import ILearn.manage.entity.Manage;
import ILearn.member.entity.Member;
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

//    Optional<Manage> findByMemberAndChapterId(Long userId, Long chapterId);

    List<Manage> findByMember(Member member);

    Optional<Manage> findByManageNumAndChapterId(Long userId, Long chapterId);

}
