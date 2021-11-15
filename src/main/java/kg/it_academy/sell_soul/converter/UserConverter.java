package kg.it_academy.sell_soul.converter;

import kg.it_academy.sell_soul.converter.base_converter.BaseConverter;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.model.UserAuthModel;

import java.util.function.Function;

public class UserConverter extends BaseConverter<UserAuthModel, User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToModel);
    }

    private static User convertToEntity(UserAuthModel userAuthModel) {
        return User.builder()
                .login(userAuthModel.getLogin())
                .password(userAuthModel.getPassword())
                .build();
    }

    private static  UserAuthModel convertToModel(User user) {
        return UserAuthModel.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
