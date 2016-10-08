package net.chandol.study.oop.task.repsoitory;


import com.querydsl.jpa.JPQLQuery;
import net.chandol.study.oop.task.model.Project;
import net.chandol.study.oop.task.model.QStatus;
import net.chandol.study.oop.task.model.Status;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static net.chandol.study.oop.common.SejongSimpleUtil.asNullSafeList;

public class StatusRepositoryImpl extends QueryDslRepositorySupport implements StatusRepositoryCustom {

    public StatusRepositoryImpl() {
        super(Status.class);
    }

    @Override
    public List<Status> findActiveStatues(Project project) {
        QStatus status = QStatus.status;
        JPQLQuery<Status> query = this.from(status)
                .where(status.project.eq(project)
                        .and(status.archive.eq(false)))
                .orderBy(status.order.asc());

        return asNullSafeList(query.fetch());
    }
}
