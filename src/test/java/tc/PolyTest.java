/******************************************************************************
 ** This data and information is proprietary to, and a valuable trade secret
 ** of, Basis Technology Corp.  It is given in confidence by Basis Technology
 ** and may only be used as permitted under the license agreement under which
 ** it has been distributed, and in no other way.
 **
 ** Copyright (c) 2015 Basis Technology Corporation All rights reserved.
 **
 ** The technical data and information provided herein are provided with
 ** `limited rights', and the computer software provided herein is provided
 ** with `restricted rights' as those terms are defined in DAR and ASPR
 ** 7-104.9(a).
 ******************************************************************************/

package tc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Does the hairy deserialization work?
 */
public class PolyTest {

    @Test
    public void batchWorkItemRequest() throws Exception {
        Base<Poly1> req = new Base<Poly1>();
        Poly1 o = new Poly1();
        req.setVal("some value");
        Top top = new Top("/categories", req);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(top);
        JsonNode tree = mapper.readTree(json);
        assertNotNull(tree.get("b"));
        assertNotNull(tree.get("b").get("options"));

        // Can we reverse the process? I have some doubts
        Top itemRead = mapper.readValue(json, Top.class);
        assertNotNull(itemRead);
        assertNotNull(itemRead.getKey());
    }
}
