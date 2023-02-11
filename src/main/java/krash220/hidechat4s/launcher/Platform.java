package krash220.hidechat4s.launcher;

public enum Platform {
    FORGE, FABRIC;

    @Override
    public String toString() {
        return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
    }
}
