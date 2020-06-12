package srp06.move.accumulation.to.collecting.parameter;

import java.util.ArrayList;
import java.util.List;

class Event {
    public Event(String chairman) {
        this.chairman = chairman;
    }

    private String chairman;

    public String getChairman() {
        return chairman;
    }
}

class StateEvent extends Event {
    public StateEvent(String chairman) {
        super(chairman);
    }
}

class DistrictEvent extends Event {
    public DistrictEvent(String chairman) {
        super(chairman);
    }
}

class CityEvent extends Event {
    public CityEvent(String chairman) {
        super(chairman);
    }
}

public class Demo {
    private List<StateEvent> allStateEvents = new ArrayList<>();
    private List<DistrictEvent> allDistrictEvents = new ArrayList<>();
    private List<CityEvent> allCityEvents = new ArrayList<>();

    public List<Event> filterEvents() {
        List<Event> filteredEvents = new ArrayList<Event>();

        for (StateEvent stateEvent : allStateEvents) {
            //if some logic is true then
            filteredEvents.add(stateEvent);
        }

        for (DistrictEvent districtEvent : allDistrictEvents) {
            for (Event event : filteredEvents) {
                if (event.getChairman().equals(districtEvent.getChairman())) {
                    filteredEvents.add(districtEvent);
                }
            }
        }

        for (CityEvent cityEvent: allCityEvents)
        {
            //if some logic is true then
            filteredEvents.add(cityEvent);
        }
        // ... continues ...
        return filteredEvents;
    }
}
