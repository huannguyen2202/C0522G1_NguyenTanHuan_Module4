package book_management.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
    int count = 0;

    @Pointcut("within(book_management.controller.BookController*)")
    public void addMethodPointCut() {
    }

    @Around("addMethodPointCut()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        count++;
        System.err.println("method:" + value + " số lượng người đã ghé thăm thư viện sách:" + count);
        return value;
    }

    @Pointcut("execution(* book_management.controller.BookController.updateBook(..))")
    public void updateBookPointCut() {
    }

    @AfterReturning("updateBookPointCut()")
    public void borrowBook(JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Pointcut("execution(* book_management.controller.BookController.payBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBook(JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }

}
