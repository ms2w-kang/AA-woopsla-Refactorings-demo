package srp06.move.accumulation.to.collecting.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagNodeTest {
	@Test
	public void testToString() throws Exception {
		TagNode node = new TagNode("html", "", "");
		TagNode node2 = new TagNode("head", "", "");
		TagNode node3 = new TagNode("dummy", "width=10", "Hello");

		/*
		 * <html >
		 *     <head >
		 *     	    <style ></style>
		 *          <dummy width=10>Hello</dummy>
		 *     </head>
		 * </html>
		 */
		node.addNode(node2);
		node2.addNode(new TagNode("style", "", ""));
		node2.addNode(node3);

		assertEquals("<html ><head ><style ></style><dummy width=10>Hello</dummy></head></html>", node.toString());
	}
}
