package pl.edu.pjwstk.assetManager.model;

import java.util.Objects;

public class AssetImpl implements Asset {
    static int count;
    final int id;
    AssetType type;
    final int ownerId;
    int controllerId;

    public AssetImpl(int ownerId) {
        this.id = count++;
        this.ownerId = ownerId;
    }

    @Override
    public int getOwnerId() {
        return this.ownerId;
    }

    @Override
    public int getControllerId() {
        return this.controllerId;
    }

    @Override
    public boolean isActive() {
        return controllerId == 0;
    }

    @Override
    public boolean reserve(int controllerId) {
        this.controllerId = controllerId;
        return true;
    }

    @Override
    public boolean clear() {
        this.controllerId = 0;
        return true;
    }

    @Override
    public void setType(AssetType type) {
        this.type = type;
    }

    @Override
    public AssetType getType() {
        return type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetImpl asset = (AssetImpl) o;
        return type == asset.type;
    }
}
