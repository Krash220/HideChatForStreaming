package net.minecraftforge.fml.common.gameevent;

// For 1.13
public class TickEvent {

    public enum Phase {
        START, END;
    }

    public Phase phase;

    public static class RenderTickEvent extends TickEvent {
        public RenderTickEvent() {}
    }
}