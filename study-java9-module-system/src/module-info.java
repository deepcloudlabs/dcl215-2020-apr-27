import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;

module lottery.app.module {
    requires random.number.module;
    requires lottery.module;
    uses LotteryService;
    uses RandomNumberGenerator;
}