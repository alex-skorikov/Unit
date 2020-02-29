package ru.skorikov.service.ReaderWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterIMPL implements ReaderWriter {
    private String file;
    private BufferedReader reader;

    public ReaderWriterIMPL(String file) {
        this.file = file;
    }

    public String read() throws IOException {
        String out = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            out = reader.readLine();
        }
        return out;
    }
}
