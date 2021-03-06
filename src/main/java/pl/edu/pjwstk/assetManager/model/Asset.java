package pl.edu.pjwstk.assetManager.model;

public interface Asset {
    void setType(AssetType type);
    AssetType getType();
    int getId();
    int getOwnerId();
    int getControllerId();
    boolean isActive();
    boolean reserve(int controllerId);
    boolean clear();
}
