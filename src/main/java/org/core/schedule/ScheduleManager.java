package org.core.schedule;

import java.util.Collection;

public interface ScheduleManager {

    SchedulerBuilder schedule();

    Collection<Scheduler> getSchedules();
}
