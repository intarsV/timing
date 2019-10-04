package lv.initex.database.implementations;

import lv.initex.database.LogoRepository;
import lv.initex.domain.Logo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class LogoRepositoryImpl extends Repository implements LogoRepository {
    @Override
    public List<Logo> logoList() {
        return session()
                .createCriteria(Logo.class)
                .list();
    }
}
