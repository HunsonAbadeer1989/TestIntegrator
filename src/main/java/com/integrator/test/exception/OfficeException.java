package com.integrator.test.exception;

/**
 * Класс для исключений связанных с офисами
 */
public class OfficeException extends RuntimeException {

    /**
     * Конструктор с параметром класса OfficeException
     *
     * @param message сообщение об ошибке
     */
    public OfficeException(String message) {
        super(message);
    }

    /**
     * Конструктор с параметром класса OfficeException
     *
     * @param message сообщение об ошибке
     * @param cause   причина ошибки
     */
    public OfficeException(String message, Throwable cause) {
        super(message, cause);
    }
}
