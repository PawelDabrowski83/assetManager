package pl.edu.pjwstk.assetManager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.edu.pjwstk.assetManager.exception.UnknownAssetException;
import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetType;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssetFactoryTest {

    static AssetFactory assetFactory = new AssetFactory();
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

    @Test()
    public void shouldCreateAssetGivenNullThrowException() {
        assertThatThrownBy(() -> assetFactory.createAsset(null)).isInstanceOf(UnknownAssetException.class);
    }

    @ParameterizedTest
    @MethodSource("createAssetsArgumentProvider")
    void shouldCreateAssetsWork(int a, int b, int c, Set<Asset> expectedAssets) {
        // when
        Set<Asset> assetSet = assetFactory.createAssetSet(a, b, c);

        // then
        assertThat(assetSet).isEqualTo(expectedAssets);

    }

    private static Stream<Arguments> createAssetsArgumentProvider() {
        return Stream.of(
                Arguments.of(
                        1, 0, 0, Stream.of(
                                assetFactory.createAsset(AssetType.A)
                        ).collect(Collectors.toCollection(HashSet::new))
                ),
                Arguments.of(
                        1, 2, 0, Stream.of(
                                assetFactory.createAsset(AssetType.A),
                                assetFactory.createAsset(AssetType.B),
                                assetFactory.createAsset(AssetType.B)
                        ).collect(Collectors.toCollection(HashSet::new))

                ),
                Arguments.of(
                        1, 0, 1, Stream.of(
                                assetFactory.createAsset(AssetType.A),
                                assetFactory.createAsset(AssetType.C)
                        ).collect(Collectors.toCollection(HashSet::new))
                ),
                Arguments.of(
                        0, 0, 4, Stream.of(
                                assetFactory.createAsset(AssetType.C),
                                assetFactory.createAsset(AssetType.C),
                                assetFactory.createAsset(AssetType.C),
                                assetFactory.createAsset(AssetType.C)
                        ).collect(Collectors.toCollection(HashSet::new))

                )

        );
    }

}
