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

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

/**
 *
 */
public class Top {
    private String key;
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.CUSTOM,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "key")
    @JsonTypeIdResolver(Resolver.class)
    private Base b;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Base getB() {
        return b;
    }

    public void setB(Base b) {
        this.b = b;
    }
}
