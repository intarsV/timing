package lv.initex.database.implementations;

import lv.initex.database.UserRepository;
import lv.initex.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class UserRepositoryImpl extends Repository implements UserRepository {

    @Override
    public Optional<User> findByLogin(String login) {

        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        return Optional.ofNullable(user);


    }
}

