package com.devcourse.mediator.module.mediator;

import com.devcourse.mediator.module.component.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandCenter implements Mediator {

    private List<Unit> units;

    public CommandCenter() {
        this.units = new ArrayList<>();
    }

    @Override
    public void addUnit(Unit unit) {
        if (!units.contains(unit)) {
            this.units.add(unit);
        }
    }

    @Override
    public void deleteUnit(Unit unit) {
        if (units.contains(unit)) {
            this.units.remove(unit);
        }
    }

    @Override
    public void sendMessage(Unit unit, String message) {
        this.units.stream()
                .filter(seperateUnit -> !Objects.equals(seperateUnit, unit))
                .forEach(seperateUnit -> seperateUnit.receiveMessage(message));
    }
}
