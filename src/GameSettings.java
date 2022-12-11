import java.sql.Time;

public class GameSettings {

    private Time initialTime;
    private Time delayBeforeClockStart;
    private Time addedTimeAfterMove;

    public GameSettings(Time initialTime, Time delayBeforeClockStart, Time addedTimeAfterMove) {
        this.initialTime = initialTime;
        this.delayBeforeClockStart = delayBeforeClockStart;
        this.addedTimeAfterMove = addedTimeAfterMove;
    }
}
