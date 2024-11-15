package com.DesignPatterns.ChainOfResponsibityPattern.LogProcessor;

public class Main {
    public static void main(String[] args) {

        LogProcessor logObj = LogProcessor.createChain();

        logObj.log(LogProcessor.ERROR, "Exception happens");
        logObj.log(LogProcessor.DEBUG, "Need to debug this");
        logObj.log(LogProcessor.INFO, "This is just for Info");
        logObj.log(4, "Log level not defined");
    }
}
