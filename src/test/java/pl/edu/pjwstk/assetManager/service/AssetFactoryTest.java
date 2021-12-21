package pl.edu.pjwstk.assetManager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetType;

public class AssetFactoryTest {

    AssetFactory assetFactory = new AssetFactory();
    @Test
    public void shouldCreateProperAsset() {
        // when
        Asset assetA = assetFactory.createAsset(AssetType.A);
        Asset assetB = assetFactory.createAsset(AssetType.B);
        Asset assetC = assetFactory.createAsset(AssetType.C);

        // then
        assert(assetA.getType()).equals(AssetType.A);
        assert(assetB.getType()).equals(AssetType.B);
        assert(assetC.getType()).equals(AssetType.C);
    }

}
