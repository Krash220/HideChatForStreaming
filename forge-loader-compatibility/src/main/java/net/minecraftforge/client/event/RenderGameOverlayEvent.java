package net.minecraftforge.client.event;

public class RenderGameOverlayEvent {
    public static enum ElementType {
        ALL
    }

    /* 1.8 compatibility */
    public ElementType type;
    
    public ElementType getType() { return this.type; }

    public static class Post extends RenderGameOverlayEvent {}
    public static class Chat extends RenderGameOverlayEvent {}
}
