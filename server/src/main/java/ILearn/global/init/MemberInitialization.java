package ILearn.global.init;

import ILearn.manage.entity.Manage;
import ILearn.manage.repository.ManageRepository;
import ILearn.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Component
public class MemberInitialization {
    private final ManageRepository manageRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void initializeData() {
        // Manage 초기화
        initializeManageEntities();
    }

    private void initializeManageEntities() {
        List<Long> existingManageIds = manageRepository.findAllManageIds();

        if (existingManageIds.isEmpty()) {
            List<Manage> managesToSave = new ArrayList<>();

            for (long chapterId = 1; chapterId <= 20; chapterId++) {
                Manage chapterManage = new Manage();
                chapterManage.setManageNum(1L);
                chapterManage.setChapterId(chapterId);
                chapterManage.setChapterStatus(false);

                // Progress를 List 형태로 생성
                List<Integer> progressList = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                    progressList.add(0);
                }
                chapterManage.setProgress(progressList);

                managesToSave.add(chapterManage);
            }
            manageRepository.saveAll(managesToSave);
        }
    }
}

