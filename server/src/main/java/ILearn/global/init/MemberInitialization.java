package ILearn.global.init;

import ILearn.manage.entity.Manage;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Component
public class MemberInitialization {
    private final ManageRepository manageRepository;

    public void initializeData(Member member) {
        // 회원별로 chapterId 생성
        for (long chapterId = 1; chapterId <= 20; chapterId++) {
            Manage chapterManage = new Manage();
            chapterManage.setChapterId(chapterId);
            chapterManage.setChapterStatus(false);

            List<Integer> progressList = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                progressList.add(0);
            }
            chapterManage.setProgress(progressList);

            // 회원과 연관시키기
            chapterManage.setMember(member);
            chapterManage.setManageNum(member.getUserId());

            manageRepository.save(chapterManage);
        }
    }
}

