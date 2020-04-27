import com.example.random.service.RandomNumberGenerator;
import com.example.random.service.business.SecureRandomNumberGenerator;
import com.example.random.service.business.SimpleRandomNumberGenerator;

module random.number.module {
    exports com.example.random.service;
    provides RandomNumberGenerator with SimpleRandomNumberGenerator, SecureRandomNumberGenerator;
}