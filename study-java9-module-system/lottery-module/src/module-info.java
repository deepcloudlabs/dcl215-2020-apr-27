import com.example.lottery.service.LotteryService;
import com.example.lottery.service.impl.SimpleLotteryService;

module lottery.module {
    requires random.number.module;
    exports com.example.lottery.service;
    provides LotteryService with SimpleLotteryService;
}