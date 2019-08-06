package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository  implements  TimeEntryRepository{
    private long idCounter = 1;
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry createTimeEntry = new TimeEntry(
                idCounter++,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(createTimeEntry.getId(), createTimeEntry);
        return createTimeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (timeEntries.containsKey(id)) {
            TimeEntry updatedTimeEntry = new TimeEntry(
                    id,
                    timeEntry.getProjectId(),
                    timeEntry.getUserId(),
                    timeEntry.getDate(),
                    timeEntry.getHours()
            );

            timeEntries.replace(id, updatedTimeEntry);
            return updatedTimeEntry;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }
}
