package pl.edu.pjwstk.assetManager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.Node;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NodeFactoryTest {

    NodeFactory nodeFactory = new NodeFactory();

    @Test
    public void shouldCreateNodeReturnEmptyNode() {
        // when
        Node node = nodeFactory.createNode();

        // then
        assert(node.getAssets()).equals(Collections.emptySet());
    }

//    @ParameterizedTest
//    @MethodSource("createNodeArgumentsProvider")
//    public void shouldCreateNodeReturnProperSizeOfAssets(int a, int b, int c, Set<Asset> expectedAssets) {
//        // when
//        Node node = nodeFactory.createNode(a, b, c);
//
//        // then
//        assertThat(node.getAssets()).isEqualTo(expectedAssets);
//    }
//
//    public static Stream<Arguments> createNodeArgumentsProvider() {
//        return Stream.of(
//                Arguments.of(1, 0, 0, Set.of())
//        );
//    }

}
