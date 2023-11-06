package org.example.Repo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RepoLogger {

    private final Logger log;

    public RepoLogger(String className){
        log = Logger.getLogger(className);
    }

    protected void infoLog(String message) {
        log.log(Level.INFO, message + "\n\n");
    }

    protected void warningLog(String message) {
        log.log(Level.WARNING, message + "\n\n");
    }

}
