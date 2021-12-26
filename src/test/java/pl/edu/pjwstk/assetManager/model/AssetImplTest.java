package pl.edu.pjwstk.assetManager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.edu.pjwstk.assetManager.service.AssetFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class AssetImplTest {

    private final AssetFactory assetFactory = new AssetFactory();
    Asset asset;

    @BeforeEach
    void init() {
        asset = assetFactory.createAsset(AssetType.A);
    }

    @Test
    public void shouldIsActiveWorkProperlyWhenAssetOpen() {
        // when
        boolean actual = asset.isActive();

        // then
        assertThat(actual).isTrue();
    }

    @Test
    public void shouldIsActiveWorkProperlyWhenAssetReserved() {
        // given
        asset.reserve(10);

        // when
        boolean actual = asset.isActive();

        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 99, 80009, Integer.MAX_VALUE})
    public void shouldReserveWorkProperly(int controllerId) {
        // when
        asset.reserve(controllerId);

        // then
        assertThat(asset.getControllerId()).isEqualTo(controllerId);
    }

    @Test
    public void shouldClearWorkProperly() {
        // given
        asset.reserve(11);

        // when
        asset.clear();

        // then
        assertThat(asset.getControllerId()).isEqualTo(0);
    }

}
