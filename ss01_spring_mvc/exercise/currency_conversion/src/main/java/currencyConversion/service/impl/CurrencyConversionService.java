package currencyConversion.service.impl;

import currencyConversion.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public double covert(String usd) {
        double result = Double.parseDouble(usd) * 24000;
        return result;
    }
}
