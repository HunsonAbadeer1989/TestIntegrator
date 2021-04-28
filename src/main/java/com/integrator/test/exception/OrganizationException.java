package com.integrator.test.exception;

/**
 * Класс для исключений связанных с организациями
 */
public class OrganizationException extends RuntimeException{

    /**
     * Конструктор с параметром класса OrganizationException
     *
     * @param message сообщение об ошибке
     */
    public OrganizationException(String message){
        super(message);
    }

    /**
     * Конструктор с параметром класса OrganizationException
     *
     * @param message сообщение об ошибке
     * @param cause   причина ошибки
     */
    public OrganizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
