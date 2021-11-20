package kg.it_academy.sell_soul.service;

import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.service.base_service.BaseService;

public interface AuctionLogService extends BaseService<AuctionLog> {
    User buy(Long id);
}
