package ILearn.manage.repository;

import ILearn.manage.entity.Manage;
import ILearn.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManageRepository extends JpaRepository<Manage, Long> {
    List<Manage> findByMember(Member member);
    Optional<Manage> findByManageNumAndChapterId(Long userId, Long chapterId);

}
