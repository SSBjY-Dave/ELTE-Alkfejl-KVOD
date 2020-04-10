package hu.elte.alkfejl.DormRooms.model;

public enum RoomType {
    MALE, FEMALE, MIXED
    ;
    public boolean isGenderAllowed(Gender gender) {
        return MALE.ordinal() == gender.ordinal();
    }
}
