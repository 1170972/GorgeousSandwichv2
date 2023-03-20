package pt.isep.arqsoft.GorgeousSandwich.dto.order;

import java.util.Objects;

public class DeliveryTimeDTO {
    private String startTime;
    private String endTime;

    public DeliveryTimeDTO(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String obtainStartTime() {
        return this.startTime;
    }

    public String obtainEndTime() {
        return this.endTime;
    }

    public void changeEndTime(String endTime){
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryTimeDTO that = (DeliveryTimeDTO) o;
        return startTime.equals(that.startTime) &&
                endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}
