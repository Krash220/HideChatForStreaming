package net.minecraftforge.client.event;

import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;

// Forward Compatibility 1.19
public abstract class RenderGuiOverlayEvent {
    public static class Pre extends RenderGuiOverlayEvent {}
    public NamedGuiOverlay getOverlay() {return null;}
    public void setCanceled(boolean canceled) {}
}
