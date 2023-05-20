package com.example.otpmobil.services;

public interface LoggerService {
    void trace(String value);

    void debug(String value);

    void info(String value);

    void warn(String value);

    void error(String value);
}
