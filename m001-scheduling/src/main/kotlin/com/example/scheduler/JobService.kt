package com.example.scheduler

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class JobService {

    val logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedRate = 2000)
    @Async
    fun doRepeatableWork() {
        logger.info("do work with repeat")
        Thread.sleep(3000)
    }

    @Scheduled(fixedDelay = 3000)
    @Async
    fun doWorkWithDelay() {
        logger.info("do work after delay")
        Thread.sleep(4000)
    }

    @Scheduled(fixedRateString = "PT01M")
    fun doWorkPerMinute() {
        logger.info("do work in minute")
    }
}