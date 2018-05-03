/* (c) 2018 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.wfs3;

import org.geoserver.test.GeoServerSystemTestSupport;
import org.opengis.feature.type.Name;

import javax.servlet.Filter;
import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

public class WFS3TestSupport extends GeoServerSystemTestSupport {

    @Override
    protected List<Filter> getFilters() {
        return Collections.singletonList(new WFS3Filter(getCatalog()));
    }
    
    protected String getEncodedName(QName qName) {
        if(qName.getPrefix() != null) {
            return qName.getPrefix() + "__" + qName.getLocalPart();
        }
        else {
            return qName.getLocalPart();
        }
    }
}
