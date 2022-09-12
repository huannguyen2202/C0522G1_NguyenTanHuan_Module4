package personal_calculator.service.impl;

import org.springframework.stereotype.Service;
import personal_calculator.service.IPersonalCalculatorService;

@Service
public class PersonalCalculatorService implements IPersonalCalculatorService {
    @Override
    public String result(String number1, String number2, String operator) {
        try {
            double a = Double.parseDouble(number1);
            double b = Double.parseDouble(number2);
            double result = 0;
            switch (operator) {
                case "Addition(+)":
                    result = a + b;
                    break;
                case "Subtraction(-)":
                    result = a - b;
                    break;
                case "Multiplication(x)":
                    result = a * b;
                    break;
                case "Division(/)":
                    if (b == 0) {
                        return "Khong the chia cho so 0!!!";
                    }
                    result = a / b;
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Hay nhap vao so!!!";
        }
    }

}
