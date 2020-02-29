package ru.skorikov.service;

import ru.skorikov.domain.Unit;

import java.io.File;
import java.util.List;

public interface UnitService {
    List<Unit> getUnitsList(File file);
}
