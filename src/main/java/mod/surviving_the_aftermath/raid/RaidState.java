package mod.surviving_the_aftermath.raid;

public enum RaidState {
    START("start", 0),
    ONGOING("ongoing", 1),
    VICTORY("victory", 2),
    LOSE("lose", 3),
    CELEBRATING("celebrating", 4),
    END("end", 5);

    private final String name;
    private final int index;

    RaidState(String name, int index) {
        this.name = name;
        this.index = index;
    }

}