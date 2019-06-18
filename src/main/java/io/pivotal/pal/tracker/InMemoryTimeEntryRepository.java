package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
private Map<Long,TimeEntry> timeEntryMap = new HashMap <Long,TimeEntry>();

    private long tEntryId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {


//        timeEntry.setId(counterID);
        TimeEntry newTimeEntry = new TimeEntry(
                tEntryId,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );
        timeEntryMap.put(tEntryId,newTimeEntry);
        tEntryId++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (find(id) == null)
            return null;
        timeEntry.setId(id);

        timeEntryMap.replace(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        timeEntryMap.remove(id);
    }
}
