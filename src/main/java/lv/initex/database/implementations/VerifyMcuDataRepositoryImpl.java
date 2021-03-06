package lv.initex.database.implementations;

import lv.initex.domain.VerifyMcuData;
import lv.initex.database.VerifyMcuDataRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class VerifyMcuDataRepositoryImpl extends Repository implements VerifyMcuDataRepository {
    @Override
    public List<VerifyMcuData> startList() {
        return session()
                .createCriteria(VerifyMcuData.class)
                .add(Restrictions.eq("unitId", 1))
                .add(Restrictions.eq("accepted", false))
                .list();
    }

    @Override
    public List<VerifyMcuData> finishList() {
        return session()
                .createCriteria(VerifyMcuData.class)
                .add(Restrictions.eq("unitId", 2))
                .add(Restrictions.eq("accepted", false))
                .list();
    }

    @Override
    public List<VerifyMcuData> getListWithAccepted() {
        return session()
                .createCriteria(VerifyMcuData.class)
                .add(Restrictions.eq("accepted", true))
                .add(Restrictions.eq("done", false))
                .list();
    }

    @Override
    public int countStartLine() {
        return session()
                .createCriteria(VerifyMcuData.class)
                .add(Restrictions.eq("unitId", 1))
                .add(Restrictions.eq("accepted", false))
                .list().size();
    }

    @Override
    public int countFinishLine() {
        return session()
                .createCriteria(VerifyMcuData.class)
                .add(Restrictions.eq("unitId", 2))
                .add(Restrictions.eq("accepted", false))
                .list().size();
    }

    @Override
    public boolean update(VerifyMcuData verifyMcuData){
        session().update(verifyMcuData);
        return true;
    }

}
