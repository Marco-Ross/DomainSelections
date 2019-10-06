package com.marco.domain.timings.compositeclass;

import java.io.Serializable;
import java.util.Objects;

public class TrainScheduleId implements Serializable {
    private int scheduleID;
    private int trainID;

    public TrainScheduleId() {
    }

    public TrainScheduleId(int scheduleID, int trainID) {
        this.scheduleID = scheduleID;
        this.trainID = trainID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleID, trainID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TrainScheduleId TrainSchedId1 = (TrainScheduleId) obj;
        if (scheduleID == TrainSchedId1.scheduleID) return false;
        return trainID == TrainSchedId1.trainID;
    }
}
