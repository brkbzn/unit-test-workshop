package com.kloia.dojo;

import java.io.IOException;

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

    public void beginTransaction() throws IOException {
        if (!open) {
            throw new IOException("Connection is not opened");
        }
    }

    public void endTransaction() throws IOException {
        if (!open) {
            throw new IOException("Connection is not opened");
        }
    }

}
