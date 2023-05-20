package com.example.otpmobil.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerServiceImpl.class);

    @Override
    public void trace(String value) {
        LOGGER.trace("Custom logger needed more information - {}", value);
    }

    @Override
    public void debug(String value) {
        LOGGER.debug("Custom logger needed to debug - {}", value);
    }

    @Override
    public void info(String value) {
        LOGGER.info("Custom logger took input - {}", value);
    }

    @Override
    public void warn(String value) {
        LOGGER.warn("Custom logger needed to warn - {}", value);
    }

    @Override
    public void error(String value) {
        LOGGER.error("Custom logger encountered an error with value - {}", value);
    }
}
