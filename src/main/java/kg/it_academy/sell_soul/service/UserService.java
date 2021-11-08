package kg.it_academy.sell_soul.service;

import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.model.UserAuthModel;
import kg.it_academy.sell_soul.service.base_service.BaseService;

public interface UserService extends BaseService<User> {
    User getByUserLogin(String login);

    String getByUserAuthModel(UserAuthModel userAuthModel);
}
