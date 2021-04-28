package com.integrator.test.exception;

/**
 * Класс для исключений связанных с сотрудниками
 */
public class UserException extends RuntimeException {

    /**
     * Конструктор с параметром класса OfficeException
     *
     * @param message сообщение об ошибке
     */
    public UserException(String message) {
        super(message);
    }

    /**
     * Конструктор с параметром класса OfficeException
     *
     * @param message сообщение об ошибке
     * @param cause   причина ошибки
     */
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
