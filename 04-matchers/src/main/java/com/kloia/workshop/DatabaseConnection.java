package com.kloia.workshop;

public class DatabaseConnection {

    private boolean open = false;

    public DatabaseConnection() {
    }

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isClosed() {
        return !open;
    }


}
