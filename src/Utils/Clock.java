package Utils;

import java.sql.Time;
import java.time.LocalDateTime;

// A class that represent the clock in the game
public class Clock {

    private Time delayBeforeClockStart;
    private Time addedTimeAfterMove;
    private Time[] playersTime = new Time[2];

    private LocalDateTime startOfTurnTime;

    // Builder for clock, receive the initial time of the clock, delay before clock start at start of the player turn, and time bonus after move
    public Clock(Time initialTime, Time delayBeforeClockStart, Time addedTimeAfterMove) {
        this.delayBeforeClockStart = delayBeforeClockStart;
        this.addedTimeAfterMove = addedTimeAfterMove;
        playersTime[0] = initialTime;
        playersTime[1] = initialTime;
    }

    public void startClock(int color) {
        startOfTurnTime = LocalDateTime.now();
    }
}
