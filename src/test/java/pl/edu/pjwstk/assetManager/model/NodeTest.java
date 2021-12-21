package pl.edu.pjwstk.assetManager.model;

import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void shouldIdIterateByOneWhenCreateNewNode() {
        // given
        int expectedId = Node.getCount() + 1;

        // when
        new Node();
        Node node = new Node();
        int actualId = node.getId();

        // then
        assert(actualId == expectedId);
    }
}
