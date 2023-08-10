package com.devcourse.mediator.module.mediator;

import com.devcourse.mediator.module.component.Unit;

public interface Mediator {

    void addUnit(Unit unit);

    void deleteUnit(Unit unit);

    void sendMessage(Unit unit, String message);

}
