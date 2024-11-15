package com.DesignPatterns.ChainOfResponsibityPattern.LogProcessor;

public abstract class LogProcessor {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor logProcessor) {w
        this.nextLogProcessor = logProcessor;
    }

    public static LogProcessor createChain() {
        return new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
    }

    public void log(int logLevel, String message) {
        if(nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        } else {
            System.out.println("Default: Log level not defined");
        }
    }
}
