package lv.initex.database;

import lv.initex.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByLogin(String login);
}
