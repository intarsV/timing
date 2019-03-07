package lv.timing.database;

import lv.timing.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByLogin(String login);
}
