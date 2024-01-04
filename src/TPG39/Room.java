package TPG39;

import java.util.Objects;

public final class Room {
    private final Coordinate roomLocation;
    public boolean isEntrance;
    public boolean isFountain;
    public boolean isPit;
    public boolean hasMaelstrom;
    public boolean hasAmarok;

    public Room(Coordinate roomLocation) {
        this.roomLocation = roomLocation;
        this.isEntrance = false;
        this.isFountain = false;
        this.isPit = false;
        this.hasMaelstrom = false;
        this.hasAmarok = false;
    }

    public void setHasMaelstrom(boolean hasMaelstrom) {
        this.hasMaelstrom = hasMaelstrom;
    }

    public void setHasAmarok(boolean hasAmarok) {
        this.hasAmarok = hasAmarok;
    }

    // Getters
    public Coordinate roomLocation() {
        return roomLocation;
    }

    public boolean isEntrance() {
        return isEntrance;
    }

    // Setters
    public void setEntrance(boolean entrance) {
        isEntrance = entrance;
    }

    public boolean isFountain() {
        return isFountain;
    }

    public void setFountain(boolean fountain) {
        isFountain = fountain;
    }

    public boolean isPit() {
        return isPit;
    }

    public void setPit(boolean pit) {
        isPit = pit;
    }

    public boolean hasMaelstrom() {
        return hasMaelstrom;
    }

    public boolean hasAmarok() {
        return hasAmarok;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Room) obj;
        return Objects.equals(this.roomLocation, that.roomLocation) &&
                this.isEntrance == that.isEntrance &&
                this.isFountain == that.isFountain &&
                this.isPit == that.isPit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomLocation, isEntrance, isFountain, isPit);
    }

    @Override
    public String toString() {
        return "Room[" +
                "roomLocation=" + roomLocation + ", " +
                "isEntrance=" + isEntrance + ", " +
                "isFountain=" + isFountain + ", " +
                "isPit=" + isPit + ']';
    }


}
